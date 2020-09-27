s1_val="1"
s2_val="1"
Aval="1"
Bval="1"
Cval="1"
u_num="18"
v_num="9"
F="F"
out="gupta.iv"

CG_hw4: CG_hw4c
	@java -cp CG_hw4_classes main.java.Main $(s1_val) $(s2_val) $(Aval) $(Bval) $(Cval) $(u_num) $(v_num) $(F) $(out)

CG_hw4c:
	@javac CG_hw4_java/src/main/java/*.java  CG_hw4_java/src/main/resources/*.java -d CG_hw4_classes

clean:
	@rm -rf CG_hw4_classes/*