// Logic to calculate the next pc

package dinocpu.components

import chisel3._

/**
 * JumpPcGenerator Unit.
 * This component takes care of calculating the pc that the jump instruction is jumping to.
 *
 * Input: pc_plus_offset          True if the next pc is the current pc plus the offset (imm)
 * Input: op1_plus_offset         True if the first operand is the first operand plus the offset (imm)
 * Input: pc                      The PC of the current instruction
 * Input: op1                     The first operand of the current instruction
 * Input: offset                  The offset (imm) of the current instruction
 *
 */
class JumpPcGeneratorUnit extends Module {
  val io = IO(new Bundle {
    val pc_plus_offset    = Input(Bool())
    val op1_plus_offset   = Input(Bool())
    val pc                = Input(UInt(64.W))
    val op1               = Input(UInt(64.W))
    val offset            = Input(UInt(64.W))

    val jumppc            = Output(UInt(64.W))

  })

  // default case, i.e., not a jump instruction
  io.jumppc := 0.U

  when (io.pc_plus_offset) {
    io.jumppc := io.pc + io.offset
  }
  .elsewhen (io.op1_plus_offset) {
    io.jumppc := io.op1 + io.offset
  }
}
