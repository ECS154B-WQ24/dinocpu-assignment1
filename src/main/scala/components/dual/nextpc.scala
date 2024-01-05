// Logic to calculate the next pc

package dinocpu.components.dual

import chisel3._

/**
 * Next PC unit. This takes various inputs and outputs the next address of the next instruction.
 *
 * Input: branch         True if executing a branch instruction, False otherwise
 * Input: jumptype       00 if not a jump inst, 10 if inst is a jal, 11 if inst is a jalr
 * Input: inputx         First input
 * Input: inputy         Second input
 * Input: funct3         The funct3 from the instruction
 * Input: pc             The *current* program counter for this instruction
 * Input: imm            The sign-extended immediate
 * Input: pipeB_valid    True if pipeB is executing a valid instruction
 *
 * Output: nextpc        The address of the next instruction
 * Output: taken         True if the next pc is not pc+4
 *
 */
class DualIssueNextPC extends Module {
  val io = IO(new Bundle {
    val branch      = Input(Bool())
    val jumptype    = Input(UInt(2.W))
    val inputx      = Input(UInt(64.W))
    val inputy      = Input(UInt(64.W))
    val funct3      = Input(UInt(3.W))
    val pc          = Input(UInt(64.W))
    val imm         = Input(UInt(64.W))
    val pipeB_valid = Input(Bool())

    val nextpc      = Output(UInt(64.W))
    val taken       = Output(Bool())
  })

  // Your code goes here
}
