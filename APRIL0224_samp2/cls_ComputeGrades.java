package APRIL0224_samp2;

public class cls_ComputeGrades 
{
	float midgrd, fingrd;
	public void midGrade(float mg)
	{
		midgrd = mg;
	}
	
	public float midGrade()
	{
		return midgrd;
	}
	
	public void finGrade(float fg)
	{
		fingrd = fg;
	}
	
	public float finGrade()
	{
		return fingrd;
	}
	
	public float aveGrade()
	{
		return((midgrd + fingrd) / 2);
	}
}
