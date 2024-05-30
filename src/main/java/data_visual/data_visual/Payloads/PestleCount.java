package data_visual.data_visual.Payloads;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
public class PestleCount {
		@JsonProperty("count")
		private Long count;

		@JsonProperty("pestle")
		private String pestle;
}
