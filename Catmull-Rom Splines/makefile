F = HW2_test0.txt
N = 40
R = 0.05
T = 0
OUT = output.iv

CG_hw2: CG_hw2c
	@java -cp CG_hw2_classes main.java.Main $(F) $(N) $(R) $(T) $(OUT)

CG_hw2c:
	@javac CG_hw2_java/src/main/java/*.java  CG_hw2_java/src/main/resources/*.java -d CG_hw2_classes

clean:
	@rm -rf CG_hw2_classes/*
