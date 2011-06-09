package com.jayway.wordgraph

import scala.annotation.tailrec

object WordGraph {
// @BEGIN_VERSION REPEAT_STR
	def repeatStringLoop(string: String, count: Int) = {
	  val buffer = new StringBuilder()
	  for (i <- 0 until count) {
	    buffer append string
	  }
	  buffer toString
	}
	def repeatStringRecursive(string: String, count: Int) : String = {
		@tailrec
		def repeatStringInner(result: String, string: String, count: Int) : String = {
		  if (count > 0) {
			  repeatStringInner(result + string, string, count-1)
		  } else {
			  result
		  }
		}
		repeatStringInner("", string, count)
	}
	def repeatString(string: String, count: Int) = repeatStringRecursive(string, count)
// @END_VERSION REPEAT_STR
// @BEGIN_VERSION GATHER_WORDS_SPACE
	def gatherWords(string : String) = {
// @BEGIN_VERSION_ONLY GATHER_WORDS_SPACE
	  string.split(" ")
// @END_VERSION_ONLY GATHER_WORDS_SPACE
// @BEGIN_VERSION_ONLY GATHER_WORDS_WHITESPACE
	  string.split("\\s+").filter(_.length > 0)
// @END_VERSION_ONLY GATHER_WORDS_WHITESPACE
// @BEGIN_VERSION_ONLY GATHER_WORDS_PUNCTUATION
	  string.split("\\W+").filter(_.length > 0)
// @END_VERSION_ONLY GATHER_WORDS_PUNCTUATION
// @BEGIN_VERSION_ONLY GATHER_WORDS_LOWERCASE
	  string.split("\\W+").filter(_.length > 0).map(_.toLowerCase)
// @END_VERSION_ONLY GATHER_WORDS_LOWERCASE
	}
// @END_VERSION GATHER_WORDS_SPACE
// @BEGIN_VERSION COUNT_WORDS
	def countWords(words : Array[String]) = {
	  def wordCountAdder(wordsWithCount: Map[String, Int], word: String) = {
	    val newCount = wordsWithCount.get(word).getOrElse(0) + 1
	    wordsWithCount + (word -> newCount)
	  }
	  words.foldLeft(Map[String,Int]())(wordCountAdder)
	}
// @END_VERSION COUNT_WORDS
// @BEGIN_VERSION SORT_COUNTED_WORDS
	def sortCountedWords(wordsWithCount: Map[String, Int]) = {
	  sortCountedWordsShort(wordsWithCount)
	}
	def sortCountedWordsShort(wordsWithCount: Map[String, Int]) = {
	  wordsWithCount.toList.sort((word1, word2) => word1._2 < word2._2)
	}
	def sortCountedWordsLong(wordsWithCount: Map[String, Int]) = {
	  def byCount(word1: (String, Int), word2: (String, Int)) = {
	    word1._2 < word2._2
	  }
	  wordsWithCount.toList.sort(byCount)
	}
// @END_VERSION SORT_COUNTED_WORDS
// @BEGIN_VERSION HISTOGRAM_ENTRY
	def histogramEntry(wordWithCount: (String, Int), width: Int) = {
	  val spaceCount = width - wordWithCount._1.length + 1
	  wordWithCount._1 + repeatString(" ", spaceCount) + repeatString("#", wordWithCount._2)
	}
// @END_VERSION HISTOGRAM_ENTRY
// @BEGIN_VERSION HISTOGRAM
	def histogram(wordsWithCount: List[(String, Int)], separator: String = System.getProperty("line.separator")) = {
	  val maxWidth = wordsWithCount.foldLeft(0)((max, word) => Math.max(max, word._1.length))
	  wordsWithCount map(histogramEntry(_, maxWidth)) mkString("", separator, separator)
	}
// @END_VERSION HISTOGRAM
}