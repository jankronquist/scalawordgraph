package com.jayway.wordgraph

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.matchers.MustMatchers

import org.scalatest.Spec

@RunWith(classOf[JUnitRunner])
class WordGraphTest extends Spec with MustMatchers {

  describe("WordGraph") {
// @BEGIN_VERSION GATHER_WORDS_SPACE
    it("should split words on space") {
	  val res = WordGraph.gatherWords("mary had a little lamb")
	  res must equal (Array("mary", "had", "a", "little", "lamb"))
    }
// @END_VERSION GATHER_WORDS_SPACE
// @BEGIN_VERSION GATHER_WORDS_WHITESPACE
    it("should split words on all whitespace") {
	  val res = WordGraph.gatherWords("   mary had a\tlittle\n   lamb    ")
	  res must equal (Array("mary", "had", "a", "little", "lamb"))
    }
// @END_VERSION GATHER_WORDS_WHITESPACE
  }
  
}
