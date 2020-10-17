F = HW1_test0.txt
N = 20
R = 0.1
OUT = out.iv

CG_hw1: CG_hw1c
	java -cp CG_hw1_classes main.java.Main $(F) $(N) $(R) $(OUT)

CG_hw1c:
	javac CG_hw1/src/main/java/*.java  CG_hw1/src/main/resources/*.java -d CG_hw1_classes

clean:
	rm -rf CG_hw1_classes/*
