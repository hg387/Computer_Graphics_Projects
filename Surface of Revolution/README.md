<br/>README for CG_hw4

<br/>Write a program, named CG_hw4, that evaluates a surface of revolution and approximates it with triangles.
The surface is defined by a Catmull-Rom spline lying in the X-Z plane, which is rotated around the Z axis.
Use a tension value of 0 for the C-R spline.
Your program should be able to output both a flat-shaded and smooth-shaded polygonal approximation of the surface.
The patch's u and θ parameters will be incremented by du (1/(num_u-1)) and dθ (1/(num_t-1)) during evaluation.
<br/>1) The command to run the program is:
	<br/>./CG_hw4  -r s1_val -t s2_val -A Aval -B Bval -C Cval -u u_num -v v_num -F > out.iv

<br/>	or 

<br/>	./CG_hw4  -r s1_val -t s2_val -A Aval -B Bval -C Cval -u u_num -v v_num -S > out.iv

<br/>	These arguments could be processed in any arbitrary order, even program should not require arguments.
	
	<br/>Example for running the program is <br/>
	./CG_hw4 -r 1 -t 1 -A 1 -B 1 -C 1 -u 18 -v 8 -S > out123.iv

<br/>	This out123.iv is generated in this example, and attached with this program folder.

<br/>2) The code for generating the normals is under CG_hw4_java/src/main/resouces/NormalGenerator.java
	This whole class does the normal calculations so, can not list the line numbers. 
	Just to explain what I did in the code. For each value of u and v, normal's co-ordinates are 
	calculated, and placed in the same order as of control points. This is made sure 
	by inheritance.   
	
