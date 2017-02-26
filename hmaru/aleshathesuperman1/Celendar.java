public class Celendar {
	
	private static final String[] dayName_Array = 
		{ "Субота", "Вівторок", "Середа", "Четвер", "П'ятниця", "Субота", "Неділя" };
	
	private int day;
	private int month;
	private int year;
	private int shift; // shift ==> dayName = dayName_Array[shift]; shift = 0 dayName = "Sunday"
	private String dayName;
		
	public Celendar(){
		setData(1, 1, 1920);
	}
	
	public Celendar(int input_Day, int input_Month, int input_Year){
		setData(input_Day, input_Month, input_Year);
	}
	
	public Celendar(int input_Day, int input_Month, int input_Year, int shift_input){
		setData(input_Day, input_Month, input_Year, shift_input);
	}
	
	//======Setters======
	public void setData(int input_Day, int input_Month, int input_Year, int shift_input){
		day = input_Day;
		month = input_Month;
		year = input_Year;
		shift = shift_input;
		dayName = findDayName();
	}
	
	public void setData(int input_Day, int input_Month, int input_Year){
		day = input_Day;
		month = input_Month;
		year = input_Year;
		shift = 2;
		dayName = findDayName();
	}
	
	public void setDay(int day_input){
		day = day_input;
		dayName = findDayName();
	}
	public void setMonth(int month_input){
		month = month_input;
		dayName = findDayName();
	}
	public void setYear(int year_input){
		year = year_input;
		dayName = findDayName();
	}
	public void setShift(int shift_input){
		shift = shift_input;
		dayName = findDayName();
	}
	
	//======Getters======
	public String getData(){
		String data = "Day: "+day+"\n"+"Month: "+month+"\n"+"Year: "+year+"\n"+"Day name: "+dayName;
		return data;
	}
	public int getDay(){
		return day;
	}
	public int getMonth(){
		return month;
	}
	public int getYear(){
		return year;
	}
	public int getShift(){
		return shift;
	}
	public String getDayName(){
		return dayName;
	}
	//===================
	
	public String findDayName(){
		int day_num = day;
		boolean leapYear = true;
		if(year != 1920){
			int year_num = year - 1;
			for(int i = 0; i < year - 1920 + 1; i++){
				if(year_num % 4 == 0 && (year_num % 100 != 0 || year_num % 400 == 0))day_num += 1;
				day_num += 365;
				year_num += 1;
			}
			if(year % 4 != 0 && (year % 100 == 0 || year % 400 != 0))leapYear = false;
		}
		
		if(month > 1){
			int month_num = month - 1;
			for(int i = 1; i < month; i++){
				if(month_num % 2 == 1 && month_num != 2)day_num += 31;
				if(month_num % 2 == 0 && month_num != 2)day_num += 30;
				if(month_num == 2){
					if(leapYear == true)day_num += 29;
					if(leapYear == false)day_num += 28;
				}
				month_num -= 1;
			}
		}	
		return dayName_Array[(shift + day_num)%7];
	}
}
