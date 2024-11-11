package Assignment2; //2

public class cls2 {
    static String facNum, facName, dep, stat;
    //static int stats;
	static cls_sort sort = new cls_sort();

    public void setFNum(String fno) {
        facNum = fno;
    }

    public void setFName(String fna) {
        facName = fna;
    }

    public void setDept(String department) {
        dep = department;
    }

    public void setStatus(String status) {
        stat = status;
    }

    public void details() 
    {
        System.out.println("\nDepartment: " + dep + "\nStatus: " + stat + "\nFaculty Number: " + facNum + " \tFaculty Name: " + facName);
        sort.sorting(stat, dep);
    }
}
