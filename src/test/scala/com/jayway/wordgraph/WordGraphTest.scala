package com.jayway.wordgraph

import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import org.scalatest.FlatSpec
import org.scalatest.matchers.ShouldMatchers
import org.scalatest.matchers.MustMatchers

import org.scalatest.Spec

@RunWith(classOf[JUnitRunner])
class WordGraphTest extends Spec with MustMatchers {

// @BEGIN_VERSION REPEAT_STR
  describe("repeatString") {
    it("returns the empty string if count is zero") {
      WordGraph.repeatString("*", 0) must equal ("")
    }
    it("repeats the input string n times") {
      WordGraph.repeatString("x", 5) must equal ("xxxxx")
    }
  }
// @END_VERSION REPEAT_STR

// @BEGIN_VERSION GATHER_WORDS_SPACE
  describe("gatherWords") {
    it("should split words on space") {
	  val res : Array[String] = WordGraph.gatherWords("mary had a little lamb")
	  res must equal (Array("mary", "had", "a", "little", "lamb"))
    }
// @BEGIN_VERSION GATHER_WORDS_WHITESPACE
    it("should split words on all whitespace") {
	  val res = WordGraph.gatherWords("   mary had a\tlittle\n   lamb    ")
	  res must equal (Array("mary", "had", "a", "little", "lamb"))
    }
// @END_VERSION GATHER_WORDS_WHITESPACE
// @BEGIN_VERSION GATHER_WORDS_PUNCTUATION
    it("should split words on punctuation") {
	  val res = WordGraph.gatherWords("., mary, had... a little; lamb!")
	  res must equal (Array("mary", "had", "a", "little", "lamb"))
    }
// @END_VERSION GATHER_WORDS_PUNCTUATION
// @BEGIN_VERSION GATHER_WORDS_LOWERCASE
    it("should ignore case") {
	  val res = WordGraph.gatherWords("., MaRy, hAd... A liTTle; lAmb!")
	  res must equal (Array("mary", "had", "a", "little", "lamb"))
    }
// @END_VERSION GATHER_WORDS_LOWERCASE
  }
// @END_VERSION GATHER_WORDS_SPACE

// @BEGIN_VERSION COUNT_WORDS
  describe("countWords") {
    it("should count words into a map") {
	  val res : Map[String,Int] = WordGraph.countWords(Array("why", "mary", "why", "mary", "why"))
	  res must contain (("mary", 2))
	  res must contain (("why", 3))
    }
  }
// @END_VERSION COUNT_WORDS
  
// @BEGIN_VERSION SORT_COUNTED_WORDS
  describe("sortCountedWords") {
    it("sorts and returns a list of word/count pairs") {
	  val res : List[(String,Int)] = WordGraph.sortCountedWords(Map("two" -> 2, "three" -> 3, "one" -> 1))
	  res must equal (List(("one", 1), ("two", 2), ("three", 3)))
    }
  }
// @END_VERSION SORT_COUNTED_WORDS

// @BEGIN_VERSION HISTOGRAM_ENTRY
  describe("histogramEntry") {
    it("can generate a single histogram entry") {
      WordGraph.histogramEntry(("abc", 6), width=3) must equal ("abc ######")
    }
  }
// @END_VERSION HISTOGRAM_ENTRY

// @BEGIN_VERSION HISTOGRAM
  describe("histogram") {
    it("can generate a histogram from word counts") {
      WordGraph.histogram(List(("mary", 2), ("why", 3)), "\n") must equal ("mary ##\nwhy  ###\n")
    }
  }
// @END_VERSION HISTOGRAM
}
