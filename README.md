This program, wordgraph, will read a text file, count word occurrences and produce
a histogram of the results.

Pre-requisites
--------------

Useful Links
--------------
I have collected some useful links here:

* http://delicious.com/kronquist/scala+reference
* http://delicious.com/kronquist/learning+scala

Introduction
------------
The purpose is to build a little utility that shows a histogram graph of the number
of occurrences of each word in a text file. Like this:

	% scala ...WordGraph "mary.txt"
	fleece     #
	but        #
	...
	lamb       ############
	mary       #############
	the        ##############

In the process, you will learn some scala and higher order functions such as map, filter and fold. 

Quick Start
-----------
Check out this lab from github.com:

	git clone git://github.com/jankronquist/scalawordgraph.git

The lab is constructed using [maven-lab-plugin](https://github.com/jayway/maven-lab-plugin).
Initialize the lab to step 0 by running:

	mvn lab:init

Move to the next step when you have solved the problem, compiled the code and
ran the tests, or if otherwise instructed to move on. You can see solutions up
to the current step in src/solution/scala. To move to the next step, do this:

	mvn lab:next

Other useful commands:

    mvn lab:currentStep
    mvn lab:reset
    mvn lab:setStep -DlabStep=n

Your workflow should be the following:

1.  See INSTRUCTIONS.txt for instructions
2.  Compile and run test cases to see what you need to do
3.  (if necessary) Check HINTS.txt file for hints.
4.  (if necessary) Check src/solution/scala for a solution.
5.  Once the tests run successfully, mvn lab:next to get the next step

Notice: You will need to create classes and methods to fix compilation errors!
Make sure to create files in src/main/scala!

Good luck!
