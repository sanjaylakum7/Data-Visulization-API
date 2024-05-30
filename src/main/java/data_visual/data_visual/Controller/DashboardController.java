package data_visual.data_visual.Controller;

import data_visual.data_visual.Model.Dashboard;
import data_visual.data_visual.Payloads.*;
import data_visual.data_visual.Service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class DashboardController {

		@Autowired
		private DashboardService dashboardService;

		@GetMapping("/")
		public List<Dashboard> getAllDataFromDashboard(){
				return dashboardService.getAllDataFromDashboard();
		}

		@GetMapping("count-pestle")
		public List<PestleCount> getCountByPestle(){
				return dashboardService.getCountByPestle();
		}

		@GetMapping("start-end-year")
		public List<StartEndYear> getStartEndYear(){
				return dashboardService.getStartYearToEndYear();
		}

		@GetMapping("sectors")
		public List<String> getAllSector(){
				return dashboardService.getDistinctSectors();
		}

		@GetMapping("topics/{sector-name}")
		public List<TopicBySector> getAllTopics(@PathVariable("sector-name") String sectorName) {
				return dashboardService.getAllTopicsBySector(sectorName);
		}
		@GetMapping("swot")
		public List<CountBySwot> getSwot(){
				return dashboardService.getAllCountBySwot();
		}
		@GetMapping("year/{start-year}/{end-year}")
		public List<Dashboard> getDataByYear(@PathVariable("start-year") String startYear,
		                                     @PathVariable("end-year") Integer endYear){
				return dashboardService.getDataByYear(startYear, endYear);
		}

		@GetMapping("sector-intensity/{start-year}/{end-year}")
		public List<SectorAndIntensityLevelByYear> getSectorAndIntensityByYear(@PathVariable("start-year") String startYear,
		                                                                       @PathVariable("end-year") Integer endYear){
				return dashboardService.getSectorAndIntensityByYear(startYear, endYear);
		}

		@GetMapping("impact-topic/{sectorName}")
		public List<ImpactAndTopicBySector> getImpactAndTopicBySector(@PathVariable("sectorName") String sectorName){
				return dashboardService.getImpactAndTopicBySector(sectorName);
		}

		@GetMapping("intensity-time")
		public List<IntensityOverTime> getIntensityOverTime(){
				return dashboardService.getIntensityOverTime();
		}

		@GetMapping("sectorWise")
		public List<SectorWiseIntensity> getSectorWiseIntensity(){
				return dashboardService.sectorWiseIntensity();
		}

		@GetMapping("different-likelihood")
		public List<DifferentLikelihood> getDifferentLikelihood(){
				return dashboardService.differentOfLikelihood();
		}
}
