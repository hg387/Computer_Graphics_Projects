CG_hw1 Description:

<br/>Programming Problem:
<br/>Write a program, named CG_hw1, that evaluates a 3D arbitrary-degree Bezier curve and approximates it with a polyline.
Your program will read in an arbitrary number of 3D points and will fit an arbitrary-degree Bezier curve to them.
The curve's u parameter will be incremented by du (1/n) during evaluation.

<br/>More info: https://www.cs.drexel.edu/~david/Classes/CS536/HWs/BezierCurve.html

<br/>HOW TO RUN THE PROGAM:
<br/>
<br/>1) First, program is written in JAVA so makefile is attached to complie and run the program.

<br/>2) Makefile has a clean command to remove the compiled code from the directory "CG_hw1_classes". This is the directory where all the complied java code stored to so, do not change/delete the directory .

<br/>3) All the input files have to be on the same level as directory CG_hw1, not inside of that directory at the same level. Example HW1_test0.txt, HW1_test1.txt, and HW1_test3.txt files are available.

<br/>4) In case of no output file specified, .iv file by default is out.iv and would be stored at the same level as CG_hw1 is at. 

<br/>5) Command to run the program:

	make CG_hw1 F=<filename> N=<n> R=<r> OUT=<out.iv>

<br/>6) Default values of filename is HW1_test0.txt, n is 20, r is 0.1, and out.iv

<br/>7) Also, we do not need to pass in any value as every argument has its own default value so command like: 
	"make CG_hw1" will work just that output file (OUT) would be out.iv, input file (F) would be HW1_test0.txt, N would be 20, R would be 0.1. 


