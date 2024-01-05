// This file contains ALU control logic.

package dinocpu.components

import chisel3._
import chisel3.util._

/**
 * The ALU control unit
 *
 * Input:  aluop        Specifying the type of instruction using ALU
 *                          . 0 for none of the below
 *                          . 1 for arithmetic instruction types (R-type or I-type)
 *                          . 2 for non-arithmetic instruction types that uses ALU (auipc/jal/jarl/Load/Store)
 * Input:  arth_type    The type of instruction (0 for R-type, 1 for I-type)
 * Input:  int_length   The integer length (0 for 64-bit, 1 for 32-bit)
 * Input:  funct7       The most significant bits of the instruction.
 * Input:  funct3       The middle three bits of the instruction (12-14).
 *
 * Output: operation    What we want the ALU to do.
 *
 * For more information, see Section 4.4 and A.5 of Patterson and Hennessy.
 * This is loosely based on figure 4.12
 */
class ALUControl extends Module {
  val io = IO(new Bundle {
    val aluop       = Input(UInt(2.W))
    val arth_type   = Input(UInt(1.W))
    val int_length    = Input(UInt(1.W))
    val funct7      = Input(UInt(7.W))
    val funct3      = Input(UInt(3.W))

    val operation   = Output(UInt(5.W))
  })

  io.operation := "b11111".U // Invalid

  // Your code goes here
}
