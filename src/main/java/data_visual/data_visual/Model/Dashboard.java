package data_visual.data_visual.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Dashboard {
		@Id
		private Integer id;
		private int endYear;
		private String cityLng;
		private String cityLat;
		private int intensity;
		private String sector;
		private String topic;
		private String insight;
		private String swot;
		private String url;
		private String region;
		private String startYear;
		private String impact;
		private String added;
		private String published;
		private String city;
		private String country;
		private int relevance;
		private String pestle;
		private String source;
		private String title;
		private int likelihood;
}
