package data_visual.data_visual.Service;

import data_visual.data_visual.Model.Dashboard;
import data_visual.data_visual.Payloads.*;
import data_visual.data_visual.Repository.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DashboardService {

		@Autowired
		private DataRepository dataRepository;
		
		public List<Dashboard> getAllDataFromDashboard(){
				return dataRepository.findAll();
		}

		public List<PestleCount> getCountByPestle(){
				List<Object[]> countByPestle = dataRepository.countByPestle();
				return countByPestle.stream().map(row -> new PestleCount((long) row[0], (String) row[1])).collect(Collectors.toList());
		}

		public List<StartEndYear> getStartYearToEndYear(){
				List<Object[]> startEndYear = dataRepository.getStartYearTOEndYear();
				return startEndYear.stream().map(row -> new StartEndYear((String) row[0], (int) row[1])).collect(Collectors.toList());
		}

		public List<String> getDistinctSectors(){
				return dataRepository.getUniqueSectors();
		}

		public List<TopicBySector> getAllTopicsBySector(String sectorName){
				List<Object[]> topics = dataRepository.getTopicBySectors(sectorName);
				return topics.stream().map(row -> new TopicBySector((long) row[0], (String) row[1])).collect(Collectors.toList());
		}

		public List<CountBySwot> getAllCountBySwot() {
				List<Object[]> swot = dataRepository.getSwot();
				return swot.stream().map(row -> new CountBySwot((long) row[0], (String) row[1])).collect(Collectors.toList());
		}

		public List<Dashboard> getDataByYear(String startYear, Integer endYear){
				return dataRepository.getDataWithYear(startYear, endYear);
		}

		public List<SectorAndIntensityLevelByYear> getSectorAndIntensityByYear(String startYear, Integer endYear){
				List<Object[]> getListOfData = dataRepository.getSectorAndIntensityByYear(startYear, endYear);
				return getListOfData.stream().map(row -> new SectorAndIntensityLevelByYear((String) row[0], (long) row[1])).collect(Collectors.toList());
		}

		public List<ImpactAndTopicBySector> getImpactAndTopicBySector(String sectorName){
				List<Object[]> impactAndTopic = dataRepository.getTopicAndImpactLevelBySector(sectorName);
				return impactAndTopic.stream().map(row -> new ImpactAndTopicBySector((BigDecimal) row[0], (String) row[1])).collect(Collectors.toList());
		}

		public List<IntensityOverTime> getIntensityOverTime(){
				List<Object[]> intensityEndYear = dataRepository.getIntensityOfOverTime();
				return intensityEndYear.stream().map(row -> new IntensityOverTime((int) row[0], (int) row[1])).collect(Collectors.toList());
		}

		public List<SectorWiseIntensity> sectorWiseIntensity(){
				List<Object[]> sectorWiseIntensity = dataRepository.getSectorWiseIntensity();
				return sectorWiseIntensity.stream().map(row -> new SectorWiseIntensity((String) row[0], (double) row[1])).collect(Collectors.toList());
		}

		public List<DifferentLikelihood> differentOfLikelihood(){
				Pageable pageable = PageRequest.of(0, 20);
				List<Object[]> differentOfLikelihood = dataRepository.differentOfLikelihood(pageable);
				return differentOfLikelihood.stream().map(row -> new DifferentLikelihood((String) row[0], (double) row[1])).collect(Collectors.toList());
		}
}
