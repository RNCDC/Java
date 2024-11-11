package Assignment2;//2

    public class cls_sort {
        static int[] depCount = new int[4]; // Array to store department counts
        static int[][] statusCount = new int[4][3]; // Array to store status counts

        public void sorting(String status, String dep) {
            int depIndex = getDepartmentIndex(dep.toUpperCase());
            int statusIndex = getStatusIndex(status.toUpperCase());

            if (depIndex != -1 && statusIndex != -1) {
                depCount[depIndex]++;
                statusCount[depIndex][statusIndex]++;
                System.out.printf("Total %s Faculty: %d\n", status, statusCount[depIndex][statusIndex]);
                System.out.printf("Total Number of %s Faculty: %d\n\n", dep, depCount[depIndex]);
            } else {
                System.out.println("Unknown Department or Status\n\n");
            }
        }

        private int getDepartmentIndex(String dep) {
            switch (dep) {
                case "COMPUTER": return 0;
                case "MATHEMATICS": return 1;
                case "FILIPINO": return 2;
                case "ENGLISH": return 3;
                default: return -1;
            }
        }

        private int getStatusIndex(String status) {
            switch (status) {
                case "REGULAR": return 0;
                case "TEMPORARY": return 1;
                case "PART TIME": return 2;
                default: return -1;
            }
        }
    }

    
   /*
   public class cls_sort {
    static int depc , depm , depf , depe ;
    static int rc, tc, pc, rm, tm, pm, rf, tf, pf, re, te, pe;
     public void sorting(String status, String dep)
    {
    	switch (dep.toUpperCase()) 
        {
             case "COMPUTER":
                 depc++;
                 switch (status.toUpperCase()) 
                 {
                     case "REGULAR":
                     	rc++;
                     	System.out.printf("Total Regular Faculty: %d\n",rc);
                         break;
                     case "TEMPORARY":
                         tc++;
                         System.out.printf("Total Temporary Faculty: %d\n",tc);
                         break;
                     case "PART TIME":
                         pc++;
                         System.out.printf("Total Part Time Faculty: %d\n",pc);
                         break;
                     default:
                    	 System.out.println("Unknown Status\n");
                    	 break;
                 }
                 System.out.printf("Total Number of Computer Faculty: %d\n\n",depc);
                 break;
             case "MATHEMATICS":
                 depm++;
                 switch (status.toUpperCase()) 
                 {
                     case "REGULAR":
                     	rm++;
                     	System.out.printf("Total Regular Faculty: %d\n",rm);
                         break;
                     case "TEMPORARY":
                         tm++;
                         System.out.printf("Total Temporary Faculty: %d\n",tm);
                         break;
                     case "PART TIME":
                         pm++;
                         System.out.printf("Total Part Time Faculty: %d\n",pm);
                         break;
                     default:
                    	 System.out.println("Unknown Status\n");
                    	 break;
                 }
                 System.out.printf("Total Number of Mathematics Faculty: %d\n\n",depm);
                 break;
             case "FILIPINO":
                 depf++;
                 switch (status.toUpperCase()) 
                 {
                     case "REGULAR":
                     	rf++;
                     	System.out.printf("Total Regular Faculty: %d\n",rf);
                         break;
                     case "TEMPORARY":
                         tf++;
                         System.out.printf("Total Temporary Faculty: %d\n",tf);
                         break;
                     case "PART TIME":
                         pf++;
                         System.out.printf("Total Part Time Faculty: %d\n",pf);
                         break;
                     default:
                    	 System.out.println("Unknown Status\n");
                    	 break;
                 }
                 System.out.printf("Total Number of Filipino Faculty: %d\n\n",depf);
                 break;
             case "ENGLISH":
                 depe++;
                 switch (status.toUpperCase()) 
                 {
                     case "REGULAR":
                     	re++;
                     	System.out.printf("Total Regular Faculty: %d\n",re);
                         break;
                     case "TEMPORARY":
                         te++;
                         System.out.printf("Total Temporary Faculty: %d\n",te);
                         break;
                     case "PART TIME":
                         pe++;
                         System.out.printf("Total Part Time Faculty: %d\n",pe);
                         break;
                     default:
                    	 System.out.println("Unknown Status\n");
                    	 break;
                 }
                 System.out.printf("Total Number of English Faculty: %d\n\n",depe);
                 break;
             default:
            	 System.out.println("Unknown Department\n\n");
            	 break;	 
         }
    } 
}*/

