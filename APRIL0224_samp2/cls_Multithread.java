package APRIL0224_samp2;

public class cls_Multithread 
{
	static String studNo, studName;
	static float midGrd, finGrd, aveGrd;
	//cls_Grades compGrd = new cls_Grades();
	cls_ComputeGrades compGrd = new cls_ComputeGrades();
	public void studNumber(String sno)
	{
		studNo = sno;
	}
	
	public void studName(String sna)
	{
		studName = sna;
	}
	
	public void method_ComputeGrades(float mid, float fin)
	{
		compGrd.midGrade(mid);
		midGrd = compGrd.finGrade();
		compGrd.finGrade(fin);
		finGrd = compGrd.finGrade();
	}
	
	public void method_Outputs()
	{
		System.out.println("Student Number: " + studNo);
		System.out.println("Student Name: " + studName);
		System.out.println("Average Grade: " + compGrd.aveGrade());
	}
}

