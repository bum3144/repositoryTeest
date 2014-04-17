package vo;

public class CourseVo {
	private int 			no;
	private String 	title;
	private String 	description;
	private int 			hour;
	
	public int getNo() {
		return no;
	}
	public CourseVo setNo(int no) {
		this.no = no;
		return this;
	}
	public String getTitle() {
		return title;
	}
	public CourseVo setTitle(String title) {
		this.title = title;
		return this;
	}
	public String getDescription() {
		return description;
	}
	public CourseVo setDescription(String description) {
		this.description = description;
		return this;
	}
	public int getHour() {
		return hour;
	}
	public CourseVo setHour(int hour) {
		this.hour = hour;
		return this;
	}
}
