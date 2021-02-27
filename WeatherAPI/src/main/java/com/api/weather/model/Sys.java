package com.api.weather.model;

public class Sys {
	 public Integer type;
	    public Integer id;
	    public Double message;
	    public String country;
	    public Integer sunrise;
	    public Integer sunset;
		public Integer getType() {
			return type;
		}
		public void setType(Integer type) {
			this.type = type;
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Double getMessage() {
			return message;
		}
		public void setMessage(Double message) {
			this.message = message;
		}
		public String getCountry() {
			return country;
		}
		public void setCountry(String country) {
			this.country = country;
		}
		public Integer getSunrise() {
			return sunrise;
		}
		public void setSunrise(Integer sunrise) {
			this.sunrise = sunrise;
		}
		public Integer getSunset() {
			return sunset;
		}
		public void setSunset(Integer sunset) {
			this.sunset = sunset;
		}
		@Override
		public String toString() {
			return "Sys [type=" + type + ", id=" + id + ", message=" + message + ", country=" + country + ", sunrise="
					+ sunrise + ", sunset=" + sunset + "]";
		}
		
}
