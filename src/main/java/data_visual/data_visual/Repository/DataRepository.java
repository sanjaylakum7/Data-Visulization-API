package data_visual.data_visual.Repository;

import data_visual.data_visual.Model.Dashboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import org.springframework.data.domain.Pageable;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Dashboard, Integer>{

		@Query("SELECT COUNT(d), d.pestle FROM Dashboard d GROUP BY d.pestle")
		List<Object[]> countByPestle();

		@Query("SELECT d.startYear, d.endYear FROM Dashboard d")
		List<Object[]> getStartYearTOEndYear();

		@Query("SELECT DISTINCT d.sector FROM Dashboard d where d.sector != \"\"")
		ArrayList<String> getUniqueSectors();

		@Query("SELECT COUNT(d), topic FROM Dashboard d WHERE d.sector = :sectorName GROUP BY d.topic")
		List<Object[]> getTopicBySectors(@Param("sectorName") String sectorName);

		@Query("SELECT COUNT(d), swot FROM Dashboard d WHERE d.swot != \"\" GROUP BY d.swot")
		List<Object[]> getSwot();

		@Query("SELECT d FROM Dashboard d WHERE d.startYear >= :startYear and d.endYear <= :endYear")
		List<Dashboard> getDataWithYear(@Param("startYear") String startYear, @Param("endYear") Integer endYear);

		@Query("SELECT d.sector, SUM(d.intensity) FROM Dashboard d WHERE d.startYear >= :startYear and d.endYear <= " +
						":endYear GROUP BY d.sector")
		List<Object[]> getSectorAndIntensityByYear(@Param("startYear") String startYear, @Param("endYear") Integer endYear);

		@Query("SELECT SUM(impact), topic FROM Dashboard d WHERE d.sector = :sectorName GROUP BY d.topic")
		List<Object[]> getTopicAndImpactLevelBySector(@Param("sectorName") String sectorName);

		@Query("SELECT d.endYear, d.intensity FROM Dashboard d")
		List<Object[]> getIntensityOfOverTime();

		@Query("SELECT d.sector, avg(d.intensity) FROM Dashboard d WHERE d.sector != \"\" GROUP BY d.sector")
		List<Object[]> getSectorWiseIntensity();

		@Query("SELECT d.topic, avg(d.likelihood) FROM Dashboard d WHERE d.topic != \"\" GROUP BY d.topic")
		List<Object[]> differentOfLikelihood(Pageable pageable);
}
