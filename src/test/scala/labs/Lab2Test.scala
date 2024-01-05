// Tests for Lab 2. Feel free to modify and add more tests here.
// If you name your test class something that ends with "TesterLab2" it will
// automatically be run when you use `Lab2 / test` at the sbt prompt.

package dinocpu

import dinocpu._
import chisel3._
import chisel3.iotesters.{ChiselFlatSpec, Driver, PeekPokeTester}
import dinocpu.components._
import dinocpu.test._
import dinocpu.test.components._


/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleRTypeTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleRTypeTesterLab2'
  * }}}
  */
class SingleCycleRTypeTesterLab2 extends CPUFlatSpec {
  behavior of "Single Cycle CPU"
  for (test <- InstTests.rtype) {
    it should s"run R-type instruction ${test.binary}${test.extraName}" in {
      CPUTesterDriver(test, "single-cycle") should be(true)
    }
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleRTypeTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleRTypeTesterLab2'
  * }}}
  */
class SingleCycleRTypeMExtensionTesterLab2 extends CPUFlatSpec {
  behavior of "Single Cycle CPU"
  for (test <- InstTests.rtypeMExtension) {
    it should s"run R-type instruction ${test.binary}${test.extraName}" in {
      CPUTesterDriver(test, "single-cycle") should be(true)
    }
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleITypeTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleITypeTesterLab2'
  * }}}
  *
*/
class SingleCycleITypeTesterLab2 extends CPUFlatSpec {

  val maxInt = BigInt("FFFFFFFFFFFFFFFF", 16)

  def twoscomp(v: BigInt) : BigInt = {
    if (v < 0) {
      return maxInt + v + 1
    } else {
      return v
    }
  }

  val tests = InstTests.tests("itype")
  for (test <- tests) {
    "Single Cycle CPU" should s"run I-Type instruction ${test.binary}${test.extraName}" in {
      CPUTesterDriver(test, "single-cycle") should be(true)
    }
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleLoadTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleLoadTesterLab2'
  * }}}
  *
*/
class SingleCycleLoadTesterLab2 extends CPUFlatSpec {

  val tests = List[CPUTestCase](
    InstTests.nameMap("ld1"), InstTests.nameMap("ld2"), InstTests.nameMap("ldfwd")
 )
  for (test <- tests) {
    "Single Cycle CPU" should s"run load instruction test ${test.binary}${test.extraName}" in {
      CPUTesterDriver(test, "single-cycle") should be(true)
    }
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleUTypeTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleUTypeTesterLab2'
  * }}}
  *
*/
class SingleCycleUTypeTesterLab2 extends CPUFlatSpec {

  val tests = InstTests.tests("utype")
  for (test <- tests) {
  "Single Cycle CPU" should s"run auipc/lui instruction test ${test.binary}${test.extraName}" in {
    CPUTesterDriver(test, "single-cycle") should be(true)
	}
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleStoreTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleStoreTesterLab2'
  * }}}
  *
*/
class SingleCycleStoreTesterLab2 extends CPUFlatSpec {

  val tests = List[CPUTestCase](
    InstTests.nameMap("sd1"), InstTests.nameMap("sd2")
 )
  for (test <- tests) {
  "Single Cycle CPU" should s"run add Store instruction test ${test.binary}${test.extraName}" in {
    CPUTesterDriver(test, "single-cycle") should be(true)
	}
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleLoadStoreTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleLoadStoreTesterLab2'
  * }}}
  *
*/
class SingleCycleLoadStoreTesterLab2 extends CPUFlatSpec {

  val tests = InstTests.tests("memory")
  for (test <- tests) {
  "Single Cycle CPU" should s"run load/store instruction test ${test.binary}${test.extraName}" in {
    CPUTesterDriver(test, "single-cycle") should be(true)
	}
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleBranchTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleBranchTesterLab2'
  * }}}
  *
*/
class SingleCycleBranchTesterLab2 extends CPUFlatSpec {
  behavior of "Single Cycle CPU"
  for (test <- InstTests.branch) {
    it should s"run branch instruction test ${test.binary}${test.extraName}" in {
      CPUTesterDriver(test, "single-cycle") should be(true)
    }
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleJALTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleJALTesterLab2'
  * }}}
  *
*/
class SingleCycleJALTesterLab2 extends CPUFlatSpec {

  val tests = List[CPUTestCase](
    InstTests.nameMap("jal")
)
  for (test <- tests) {
  "Single Cycle CPU" should s"run JAL instruction test ${test.binary}${test.extraName}" in {
    CPUTesterDriver(test, "single-cycle") should be(true)
	}
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleJALRTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleJALRTesterLab2'
  * }}}
  *
*/
class SingleCycleJALRTesterLab2 extends CPUFlatSpec {

  val tests = List[CPUTestCase](
    InstTests.nameMap("jalr0"), InstTests.nameMap("jalr1")
 )
  for (test <- tests) {
  "Single Cycle CPU" should s"run JALR instruction test ${test.binary}${test.extraName}" in {
    CPUTesterDriver(test, "single-cycle") should be(true)
	}
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.SingleCycleApplicationsTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.SingleCycleApplicationsTesterLab2'
  * }}}
  *
*/
class SingleCycleApplicationsTesterLab2 extends CPUFlatSpec {

  val tests = InstTests.tests("smallApplications")
  for (test <- tests) {
  "Single Cycle CPU" should s"run application test ${test.binary}${test.extraName}" in {
    CPUTesterDriver(test, "single-cycle") should be(true)
	}
  }
}

// Unit tests for the main control logic

/*
**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.ControlTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.ControlTesterLab2'
  * }}}
  */
class ControlTesterLab2 extends ChiselFlatSpec {
  "Control" should s"match expectations" in {
    Driver(() => new Control) {
      c => new ControlUnitTester(c)
    } should be (true)
  }
}

class NextPCBrTester(c: JumpDetectionUnit) extends PeekPokeTester(c) {
  private val ctl = c
  
  val tests = List(
    //            jumpop, operand1, operand2,   funct3,  pc_plus_offset,  op1_plus_offset,   taken
    (                3.U,     13.U,      9.U, "b000".U,          false.B,      false.B, false.B,  "beq0"),
    (                3.U,    133.U,    133.U, "b000".U,           true.B,      false.B,  true.B,  "beq1"),
    (                3.U,     13.U,      9.U, "b001".U,           true.B,      false.B,  true.B,  "bne"),
    (                3.U,     13.U,      9.U, "b100".U,          false.B,      false.B, false.B,  "blt"),
    (                3.U,     13.U,      9.U, "b101".U,           true.B,      false.B,  true.B,  "bge"),
    (                3.U,     13.U,      9.U, "b110".U,          false.B,      false.B, false.B,  "bltu"),
    (                3.U,     13.U,      9.U, "b111".U,           true.B,      false.B,  true.B,  "bgeu")
  )

  for (t <- tests) {
    poke(ctl.io.jumpop, t._1)
    poke(ctl.io.operand1, t._2)
    poke(ctl.io.operand2, t._3)
    poke(ctl.io.funct3, t._4)
    step(1)
    expect(ctl.io.pc_plus_offset, t._5, s"${t._8} wrong")
    expect(ctl.io.op1_plus_offset, t._6, s"${t._8} wrong")
    expect(ctl.io.taken,  t._7, s"${t._8} wrong")
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.NextPCBranchTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.NextPCBranchTesterLab2'
  * }}}
  */

class NextPCBranchTesterLab2 extends ChiselFlatSpec {
  "NextPC" should s"match expectations for each intruction type" in {
    Driver(() => new JumpDetectionUnit) {
      c => new NextPCBrTester(c)
    } should be (true)
  }
}

class NextPCJalTester(c: JumpDetectionUnit) extends PeekPokeTester(c) {
  private val ctl = c
  val tests = List(
    //            jumpop, operand1, operand2,   funct3,  pc_plus_offset,  op1_plus_offset,   taken
      (              1.U,     13.U,      9.U, "b000".U,           true.B,       false.B,    true.B, "jal0"),
      (              1.U,    133.U,    133.U, "b000".U,           true.B,       false.B,    true.B, "jal1")
  )

  for (t <- tests) {
    poke(ctl.io.jumpop, t._1)
    poke(ctl.io.operand1, t._2)
    poke(ctl.io.operand2, t._3)
    poke(ctl.io.funct3, t._4)
    step(1)
    expect(ctl.io.pc_plus_offset, t._5, s"${t._8} wrong")
    expect(ctl.io.op1_plus_offset, t._6, s"${t._8} wrong")
    expect(ctl.io.taken,  t._7, s"${t._8} wrong")
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.NextPCJalTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.NextPCJalTesterLab2'
  * }}}
  */

class NextPCJalTesterLab2 extends ChiselFlatSpec {
  "NextPC" should s"match expectations for each intruction type" in {
    Driver(() => new JumpDetectionUnit) {
      c => new NextPCJalTester(c)
    } should be (true)
  }
}

class NextPCJalrTester(c: JumpDetectionUnit) extends PeekPokeTester(c) {
  private val ctl = c

  val tests = List(
    //            jumpop, operand1, operand2,   funct3,  pc_plus_offset,  op1_plus_offset,   taken
    (                2.U,     44.U,     99.U,      0.U,         false.B,        true.B, true.B, "jalr0"),
    (                2.U,    112.U,     19.U,      0.U,         false.B,        true.B, true.B, "jalr1")
  )

  for (t <- tests) {
    poke(ctl.io.jumpop, t._1)
    poke(ctl.io.operand1, t._2)
    poke(ctl.io.operand2, t._3)
    poke(ctl.io.funct3, t._4)
    step(1)
    expect(ctl.io.pc_plus_offset, t._5, s"${t._8} wrong")
    expect(ctl.io.op1_plus_offset, t._6, s"${t._8} wrong")
    expect(ctl.io.taken,  t._7, s"${t._8} wrong")
  }
}


/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.NextPCJalrTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.NextPCJalrTesterLab2'
  * }}}
  */

class NextPCJalrTesterLab2 extends ChiselFlatSpec {
  "NextPC" should s"match expectations for each intruction type" in {
    Driver(() => new JumpDetectionUnit) {
      c => new NextPCJalrTester(c)
    } should be (true)
  }
}


class NextPCTester(c: JumpDetectionUnit) extends PeekPokeTester(c) {
  private val ctl = c

  val tests = List(
    //            jumpop, operand1, operand2,   funct3,  pc_plus_offset, op1_plus_offset,   taken
    (                0.U,    143.U,     92.U, "b000".U,         false.B,      false.B, false.B, "none0"),
    (                3.U,     13.U,      9.U, "b000".U,         false.B,      false.B, false.B,  "beqF"),
    (                3.U,    133.U,    133.U, "b000".U,          true.B,      false.B,  true.B,  "beqT"),
    (                3.U,     11.U,      7.U, "b001".U,          true.B,      false.B,  true.B,  "bneT"),
    (                3.U,     14.U,     14.U, "b001".U,         false.B,      false.B, false.B,  "bneF"),
    (                3.U,     13.U,      9.U, "b100".U,         false.B,      false.B, false.B,  "bltF"),
    (                3.U,      5.U,      7.U, "b100".U,          true.B,      false.B,  true.B,  "bltT"),
    (                3.U,    130.U,    130.U, "b101".U,          true.B,      false.B,  true.B,  "bgeT"),
    (                3.U,     13.U,     94.U, "b101".U,         false.B,      false.B, false.B,  "bgeF"),
    (                3.U,     13.U,      9.U, "b110".U,         false.B,      false.B, false.B, "bltuF"),
    (                3.U,      4.U,      8.U, "b110".U,          true.B,      false.B,  true.B, "bltuT"),
    (                0.U,    151.U,     55.U, "b000".U,         false.B,      false.B, false.B, "none1"),
    (                3.U,     13.U,      9.U, "b111".U,          true.B,      false.B,  true.B, "bgeuT"),
    (                3.U,     11.U,    117.U, "b111".U,         false.B,      false.B, false.B, "bgeuF"),
    (                1.U,     13.U,      9.U, "b000".U,          true.B,      false.B,  true.B,  "jal0"),
    (                1.U,    133.U,    133.U, "b000".U,          true.B,      false.B,  true.B,  "jal1"),
    (                2.U,    100.U,    919.U, "b000".U,         false.B,       true.B,  true.B, "jalr0"),
    (                2.U,    116.U,    119.U, "b000".U,         false.B,       true.B,  true.B, "jalr1")
  )

  for (t <- tests) {
    poke(ctl.io.jumpop, t._1)
    poke(ctl.io.operand1, t._2)
    poke(ctl.io.operand2, t._3)
    poke(ctl.io.funct3, t._4)
    step(1)
    expect(ctl.io.pc_plus_offset, t._5, s"${t._8} wrong")
    expect(ctl.io.op1_plus_offset, t._6, s"${t._8} wrong")
    expect(ctl.io.taken,  t._7, s"${t._8} wrong")
  }
}

/**
  * This is a trivial example of how to run this Specification
  * From within sbt use:
  * {{{
  * Lab2 / testOnly dinocpu.NextPCTesterLab2
  * }}}
  * From a terminal shell use:
  * {{{
  * sbt 'Lab2 / testOnly dinocpu.NextPCTesterLab2'
  * }}}
  */

class NextPCTesterLab2 extends ChiselFlatSpec {
  "NextPC" should s"match expectations for each intruction type" in {
    Driver(() => new JumpDetectionUnit) {
      c => new NextPCTester(c)
    } should be (true)
  }
}

