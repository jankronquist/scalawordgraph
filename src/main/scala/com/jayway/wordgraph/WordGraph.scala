package com.jayway.wordgraph

object WordGraph {
	def gatherWords(string : String) = {
// @BEGIN_VERSION_ONLY GATHER_WORDS_WHITESPACE
	  string.split("\\s+").filter(_.length > 0)
// @END_VERSION_ONLY GATHER_WORDS_WHITESPACE
	}
}