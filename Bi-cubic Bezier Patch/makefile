f = patchPoints.txt
U = 11
V = 11
F = F
r = 0.1
OUT = output.iv

CG_hw3: CG_hw3c
	@java -cp CG_hw3_classes main.java.Main $(f) $(V) $(U) $(F) $(R) $(OUT)

CG_hw3c:
	@javac CG_hw3_java/src/main/java/*.java  CG_hw3_java/src/main/resources/*.java -d CG_hw3_classes

clean:
	@rm -rf CG_hw3_classes/*
