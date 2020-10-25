<br/>README for CG_hw5
<br/Write a program, named CG_hw5, that evaluates a hierarchical, robot-like model. Given a description of a 4-link, 3-joint robot, calculate the positions and orientations of the robot's links in world coordinates. You will be given the relative transformations from one link to the next, and the lengths of the four links will be parameters of the robot, along with its joint angles.
The links should be represented by rectangular cuboids. You may use the description of the cuboids in the example Inventor file for your own program and output. The focus of the assignment is calculating the correct transformations of each link of the "robot" and applying them to the links' vertices. The output of your program should be 4 cuboids (defined with polylines) and two spheres. One sphere (with radius 0.2) should be placed at the origin. The second sphere (with radius 0.2) should be placed at the end of the fourth link.
<br/ More info: https://www.cs.drexel.edu/~david/Classes/CS536/HWs/Assignment5_old.html
<br/>1) The command to run the program is:
<br/	./CG_hw5 -l L1 -m L2 -n L3 -t theta1 -u theta2 -v theta3 > out.iv

<br/	or 

<br/	./CG_hw5 -l 5.3 -m 2.2 -n 3.5 -t -5.3 -u 67.7 -v -33.3 > out.iv

<br/	These arguments could be processed in any arbitrary order, even program should not require arguments.
	
	<br/This out.iv is generated in this example, and attached with this program folder.
	<br/The default.iv is generated in another run with the default paramters values, and attached with this
	program folder.
 
	
