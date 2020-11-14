<br/>README for CG_hw3
<br/>Write a program, named CG_hw3, that evaluates a 3D bi-cubic Bezier patch and approximates it with triangles.
Your program should be able to output both a flat-shaded and smooth-shaded polygonal approximation.
The patch's u and v parameters will be incremented by du and dv during evaluation.
<br/>More info: https://www.cs.drexel.edu/~david/Classes/CS536/HWs/BezierPatch.html
<br/>1) The command to run the program is:
	<br/>./CG_hw3 -f filename -u du -v dv -r radius -F > out.iv

<br/>	or 

<br/>	./CG_hw3 -f filename -u du -v dv -r radius -S > out.iv

<br/>	These arguments could be processed in any arbitrary order, even program should not require arguments.
	
	<br/>Example for running the program is 
	<br/>./CG_hw3 -f patchPoints.txt -u 9 -v 9 -S -r 0.10 > out123.iv

<br/>	This out123.iv is generated in this example, and attached with this program folder.

<br/>2) The code for generating the normals is under CG_hw3_java/src/main/resouces/NormalGenerator.java
	This whole class does the normal calculations so, can not list the line numbers. 
	Just to explain what I did in the code. For a given u and v value, I have calculated the derivative 
	of both the binding functions co-efficents keeping the other co-efficent constant. Then, took
	those two dervied equations and did cross product of the equation for the given u and v value.  
	
