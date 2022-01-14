package com.demo.pojo;

import java.util.List;

public class People {

		private String id;
		private String name;
		
		private School school;
		
		private List<School> schoolList;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public School getSchool() {
			return school;
		}

		public void setSchool(School school) {
			this.school = school;
		}

		public List<School> getSchoolList() {
			return schoolList;
		}

		public void setSchoolList(List<School> schoolList) {
			this.schoolList = schoolList;
		}

		@Override
		public String toString() {
			return "People [id=" + id + ", name=" + name + ", school=" + school + "]";
		}


		
		
}
