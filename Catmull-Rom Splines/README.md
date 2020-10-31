CG_hww Description:

<br/>Programming Problem:

<br/>Write a program, named CG_hw2, that evaluates a 3D Catmull-Rom spline and approximates it with a polyline.
Your program will read in an arbitrary number of 3D points, along with the tangents at the first and last points, and will fit a Catmull-Rom spline to them.
A Catmull-Rom spline is a C1 piecewise curve that consists of concatenated cubic Bezier curves.
Each individual Bezier curve is parameterized from 0 to 1. The curves' u parameters will be incremented by du (1/n) during evaluation.
You should also add the "tension" property to your spline, as defined by Kochanek and Bartels.

<br/> More info: https://www.cs.drexel.edu/~david/Classes/CS536/HWs/CatmullRomCurve.html

<br/>HOW TO RUN THE PROGAM:
<br/>1) First, program is written in JAVA so makefile is attached to complie and run the program.

<br/>2) Makefile has a clean command to remove the compiled code from the directory "CG_hw2_classes". This is the directory where all the complied java code stored to so, do not change/delete the directory .

<br/>3) All the input files have to be on the same level as directory CG_hw2, not inside of that directory at the same level. Example HW2_test0.txt, HW2_test2.txt, and HW2_test3.txt files are available.

<br/>4) In case of no output file specified, .iv file by default is output.iv and would be stored at the same level as CG_hw2 is at. This also means that your output file or input files should not be named as "output.iv"

<br/>5) Command to run the program:

	./CG_hw2 -f <filename> -n <N> -r <radius> -t <tension> > out.iv

<br/>6) Default values of filename is HW2_test0.txt, n is 40 , r is 0.05, and output.iv

<br/>7) Also, we do not need to pass in any value as every argument has its own default value so command like: 
	"./CG_hw2" will work just that output file (OUT) would be output.iv, input file (F) would be HW2_test0.txt, N would be 40, R would be 0.05. 

<br/>This also means your input or output files should not be nammed as "output.iv"

