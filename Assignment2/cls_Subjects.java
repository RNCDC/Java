package Assignment2; //1

public class cls_Subjects 
{
	String studNo;
	String  studName;
	static int units, i=0, tot_units=0;
	float midGrade, finGrade;
	float aveGrade, gwa; 
	static float[] average = new float[50];
	float genAve;
	cls_ComputeGenAve compAveGrd = new cls_ComputeGenAve();
	
	public void subj_units(int unit)
	{
			units = unit;
	}
	
	public void midGrades(float mid)
	{
		midGrade = mid;
	}
	
	public void finGrades(float fin)
	{
		finGrade = fin;
	}
	public void method_call_clsComputeAveGrade(float mid, float fin)
	{
		aveGrade = compAveGrd.method_call_clsComputeAveGrade(midGrade, finGrade);
		float aver = aveGrade * units;
		method_aveGrade(aver);
		i++;
		tot_units += units;
	}
	
	private void method_aveGrade(float ave)
	{
		average[i] = ave;
	}

	public void method_call_clsComputeGenAve()
	{
		genAve = compAveGrd.computeGenAve(average, tot_units);
	}
	
	public float method_call_clsGenAve() 
	{
		gwa = genAve;
		return gwa;
	}
	
	public void studNumber(String sno)
	{
		studNo = sno;
	}
	
	public void studName(String sna)
	{
		studName = sna;
	}
	
	public void methodOutputs()
	{
		System.out.printf("\nStudent Number: %s\tStudent Name: %s\tGeneral Average: %.2f\n", studNo, studName, compAveGrd.computeGenAve(average, tot_units)); 
	}
}
