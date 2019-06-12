/*******************************************************************************
 * 	Copyright 2018 Huawei Technologies Co., Ltd.                                       
 *
 * 	Licensed under the Apache License, Version 2.0 (the "License"); you may not      
 * 	use this file except in compliance with the License. You may obtain a copy of    
 * 	the License at                                                                   
 *
 * 	    http://www.apache.org/licenses/LICENSE-2.0                                   
 *
 * 	Unless required by applicable law or agreed to in writing, software              
 * 	distributed under the License is distributed on an "AS IS" BASIS, WITHOUT        
 * 	WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the         
 * 	License for the specific language governing permissions and limitations under    
 * 	the License.                                                                     
 *******************************************************************************/
package com.huawei.openstack4j.openstack.cdn.v1.internal;

import java.util.List;

import com.google.common.base.Preconditions;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Bandwidth;
import com.huawei.openstack4j.openstack.cdn.v1.domain.BandwidthDetail;
import com.huawei.openstack4j.openstack.cdn.v1.domain.CarrierDetailSummary;
import com.huawei.openstack4j.openstack.cdn.v1.domain.DomainConsumption;
import com.huawei.openstack4j.openstack.cdn.v1.domain.DomainConsumption.DomainConsumptions;
import com.huawei.openstack4j.openstack.cdn.v1.domain.DomainSummary;
import com.huawei.openstack4j.openstack.cdn.v1.domain.DomainSummaryDetail;
import com.huawei.openstack4j.openstack.cdn.v1.domain.Flux;
import com.huawei.openstack4j.openstack.cdn.v1.domain.FluxDetail;
import com.huawei.openstack4j.openstack.cdn.v1.domain.RegionCarrierDetail;
import com.huawei.openstack4j.openstack.cdn.v1.domain.RegionCarrierDomainSummary;
import com.huawei.openstack4j.openstack.cdn.v1.domain.RegionDetailSummary;
import com.huawei.openstack4j.openstack.cdn.v1.domain.TopUrlsSummary;
import com.huawei.openstack4j.openstack.cdn.v1.exception.ServerCdnErrorResponseException;

/**
 * CDN Statistics Service
 *
 * @author ChangjunZhao
 * @date 2018-05-06
 */
public class StatisticService extends BaseCdnServices {

	/**
	 * Querying the Total Network Traffic
	 * @param domainName
	 * @return {@link Flux} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public Flux queryTotalNetworkTraffic(String domainName, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		return queryTotalNetworkTraffic(domainName,null,null, enterpriseProjectId);
	}

	/**
	 * Querying the Total Network Traffic
	 *
	 * @param domainName
	 * @param startTime
	 * @param endTime
	 * @return {@link Flux} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public Flux queryTotalNetworkTraffic(String domainName, Long startTime, Long endTime, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Invocation<Flux> fluxInvocation = get(Flux.class, uri("/statistics/flux")).param("domain_name", domainName);
		if (startTime != null) {
			fluxInvocation = fluxInvocation.param("start_time", startTime);
		}

		if (endTime != null) {
			fluxInvocation = fluxInvocation.param("end_time", endTime);
		}

		if (enterpriseProjectId != null) {
			fluxInvocation = fluxInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return fluxInvocation.execute(this.buildExecutionOptions(Flux.class));
	}

	/**
	 * Querying Details of Network Traffic
	 * @param domainName
	 * @return {@link FluxDetail} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public FluxDetail queryDetailsOfNetworkTraffic(String domainName, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		return queryDetailsOfNetworkTraffic(domainName,null,null,null, enterpriseProjectId);
	}
	/**
	 * Querying Details of Network Traffic
	 *
	 * @param domainName
	 * @param startTime
	 * @param endTime
	 * @param interval
	 * @return {@link FluxDetail} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public FluxDetail queryDetailsOfNetworkTraffic(String domainName, Long startTime, Long endTime, Integer interval, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Invocation<FluxDetail> fluxDetailInvocation = get(FluxDetail.class, uri("/statistics/flux-detail"))
				.param("domain_name", domainName);
		if (startTime != null) {
			fluxDetailInvocation = fluxDetailInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			fluxDetailInvocation = fluxDetailInvocation.param("end_time", endTime);
		}
		if (interval != null) {
			fluxDetailInvocation = fluxDetailInvocation.param("interval", interval);
		}
		if (enterpriseProjectId != null) {
			fluxDetailInvocation = fluxDetailInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return fluxDetailInvocation.execute(this.buildExecutionOptions(FluxDetail.class));
	}

	/**
	 * Querying the Peak Bandwidth Value
	 * @param domainName
	 * @return {@link Bandwidth} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public Bandwidth queryPeakBandwidth(String domainName, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		return queryPeakBandwidth(domainName,null,null, enterpriseProjectId);
	}

	/**
	 * Querying the Peak Bandwidth Value
	 *
	 * @param domainName
	 * @param startTime
	 * @param endTime
	 * @return {@link Bandwidth} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public Bandwidth queryPeakBandwidth(String domainName, Long startTime, Long endTime, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Invocation<Bandwidth> bandwidthInvocation = get(Bandwidth.class, uri("/statistics/bandwidth"))
				.param("domain_name", domainName);
		if (startTime != null) {
			bandwidthInvocation = bandwidthInvocation.param("start_time", startTime);
		}

		if (endTime != null) {
			bandwidthInvocation = bandwidthInvocation.param("end_time", endTime);
		}

		if (enterpriseProjectId != null) {
			bandwidthInvocation = bandwidthInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return bandwidthInvocation.execute(this.buildExecutionOptions(Bandwidth.class));
	}

	/**
	 * Querying Details of the Network Bandwidth
	 * @param domainName
	 * @return {@link BandwidthDetail} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public BandwidthDetail queryDetailsOfNetworkBandwidth(String domainName, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		return queryDetailsOfNetworkBandwidth(domainName,null,null,null, enterpriseProjectId);
	}

	/**
	 * Querying Details of the Network Bandwidth
	 *
	 * @param domainName
	 * @param startTime
	 * @param endTime
	 * @param interval
	 * @return {@link BandwidthDetail} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public BandwidthDetail queryDetailsOfNetworkBandwidth(String domainName, Long startTime, Long endTime,
			Integer interval, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Invocation<BandwidthDetail> bandwidthDetailInvocation = get(BandwidthDetail.class,
				uri("/statistics/bandwidth-detail")).param("domain_name", domainName);
		if (startTime != null) {
			bandwidthDetailInvocation = bandwidthDetailInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			bandwidthDetailInvocation = bandwidthDetailInvocation.param("end_time", endTime);
		}
		if (interval != null) {
			bandwidthDetailInvocation = bandwidthDetailInvocation.param("interval", interval);
		}
		if (enterpriseProjectId != null) {
			bandwidthDetailInvocation = bandwidthDetailInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return bandwidthDetailInvocation.execute(this.buildExecutionOptions(BandwidthDetail.class));
	}

	/**
	 * Querying Consumption Summary
	 * @param domainName
	 * @param statType
	 * @return {@link DomainSummary} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public DomainSummary queryConsumptionSummary(String domainName, String statType, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		return queryConsumptionSummary(domainName,statType,null,null,null,enterpriseProjectId);
	}

	/**
	 * Querying Consumption Summary
	 * @param domainName
	 * @param statType
	 * @param startTime
	 * @param endTime
	 * @param serviceArea
	 * @return {@link DomainSummary} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public DomainSummary queryConsumptionSummary(String domainName, String statType, Long startTime, Long endTime,
			String serviceArea, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(statType, "parameter `statType` should not be null");
		Invocation<DomainSummary> domainSummaryInvocation = get(DomainSummary.class,
				uri("/statistics/domain-summary")).param("domain_name", domainName).param("stat_type", statType);
		if (startTime != null) {
			domainSummaryInvocation = domainSummaryInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			domainSummaryInvocation = domainSummaryInvocation.param("end_time", endTime);
		}
		if (serviceArea != null) {
			domainSummaryInvocation = domainSummaryInvocation.param("service_area", serviceArea);
		}
		if (enterpriseProjectId != null) {
			domainSummaryInvocation = domainSummaryInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return domainSummaryInvocation.execute(this.buildExecutionOptions(DomainSummary.class));
	}

	/**
	 * Querying Consumption Details
	 * @param domainName
	 * @param statType
	 * @return {@link DomainSummaryDetail} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public DomainSummaryDetail queryConsumptionSummaryDetails(String domainName, String statType, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		return queryConsumptionSummaryDetails(domainName,statType,null,null,null,null,enterpriseProjectId);
	}

	/**
	 * Querying Consumption Details
	 * @param domainName
	 * @param statType
	 * @param startTime
	 * @param endTime
	 * @param serviceArea
	 * @param interval
	 * @return {@link DomainSummaryDetail} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public DomainSummaryDetail queryConsumptionSummaryDetails(String domainName, String statType, Long startTime, Long endTime,
			String serviceArea,Integer interval, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(statType, "parameter `statType` should not be null");
		Invocation<DomainSummaryDetail> domainSummaryDetailsInvocation = get(DomainSummaryDetail.class,
				uri("/statistics/domain-summary-detail")).param("domain_name", domainName).param("stat_type", statType);
		if (startTime != null) {
			domainSummaryDetailsInvocation = domainSummaryDetailsInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			domainSummaryDetailsInvocation = domainSummaryDetailsInvocation.param("end_time", endTime);
		}
		if (serviceArea != null) {
			domainSummaryDetailsInvocation = domainSummaryDetailsInvocation.param("service_area", serviceArea);
		}
		if (interval != null) {
			domainSummaryDetailsInvocation = domainSummaryDetailsInvocation.param("interval", interval);
		}
		if (enterpriseProjectId != null) {
			domainSummaryDetailsInvocation = domainSummaryDetailsInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return domainSummaryDetailsInvocation.execute(this.buildExecutionOptions(DomainSummaryDetail.class));
	}

	/**
	 * Querying Consumption of Each Domain Name
	 * @param domainName
	 * @param statType
	 * @return list of {@link DomainConsumption} instances
	 * @throws ServerCdnErrorResponseException
	 */
	public List<DomainConsumption> queryDomainConsumptions(String domainName, String statType, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		return queryDomainConsumptions(domainName,statType,null,null,null,enterpriseProjectId);
	}

	/**
	 * Querying Consumption of Each Domain Name
	 * @param domainName
	 * @param statType
	 * @param startTime
	 * @param endTime
	 * @param serviceArea
	 * @return list of {@link DomainConsumption} instances
	 * @throws ServerCdnErrorResponseException
	 */
	public List<DomainConsumption> queryDomainConsumptions(String domainName, String statType, Long startTime, Long endTime,
			String serviceArea, String enterpriseProjectId) throws ServerCdnErrorResponseException{
		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(statType, "parameter `statType` should not be null");
		Invocation<DomainConsumptions> domainConsumptionsInvocation = get(DomainConsumptions.class,
				uri("/statistics/domain")).param("domain_name", domainName).param("stat_type", statType);
		if (startTime != null) {
			domainConsumptionsInvocation = domainConsumptionsInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			domainConsumptionsInvocation = domainConsumptionsInvocation.param("end_time", endTime);
		}
		if (serviceArea != null) {
			domainConsumptionsInvocation = domainConsumptionsInvocation.param("service_area", serviceArea);
		}
		if (enterpriseProjectId != null) {
			domainConsumptionsInvocation = domainConsumptionsInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return domainConsumptionsInvocation.execute(this.buildExecutionOptions(DomainConsumptions.class)).getDomainConsumptions();
	}

	/**
	 * Querying region detail summary
	 *
	 * @param domainName
	 * @param statType
	 * @param region
	 * @param startTime
	 * @param endTime
	 * @return {@link RegionDetailSummary} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public RegionDetailSummary queryRegionDetailSummary(String domainName,
														String statType,
														String region,
														Long startTime,
														Long endTime,
														String enterpriseProjectId) throws ServerCdnErrorResponseException {

		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(statType, "parameter `statType` should not be null");
		Preconditions.checkNotNull(region, "parameter `region` should not be null");

		Invocation<RegionDetailSummary> regionDetailSummaryInvocation =
				get(RegionDetailSummary.class, uri("/statistics/region-detail-summary"))
						.param("domain_name", domainName)
						.param("stat_type", statType)
						.param("region", region);

		if (startTime != null) {
			regionDetailSummaryInvocation = regionDetailSummaryInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			regionDetailSummaryInvocation = regionDetailSummaryInvocation.param("end_time", endTime);
		}
		if (enterpriseProjectId != null) {
			regionDetailSummaryInvocation = regionDetailSummaryInvocation.param("enterprise_project_id", enterpriseProjectId);
		}

		return regionDetailSummaryInvocation.execute(this.buildExecutionOptions(RegionDetailSummary.class));

	}

	/**
	 * Querying carrier detail summary
	 *
	 * @param domainName
	 * @param statType
	 * @param carrier
	 * @param startTime
	 * @param endTime
	 * @return {@link CarrierDetailSummary} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public CarrierDetailSummary queryCarrierDetailSummary(String domainName,
														  String statType,
														  String carrier,
														  Long startTime,
														  Long endTime,
														  String enterpriseProjectId) throws ServerCdnErrorResponseException {

		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(statType, "parameter `statType` should not be null");
		Preconditions.checkNotNull(carrier, "parameter `carrier` should not be null");

		Invocation<CarrierDetailSummary> carrierDetailSummaryInvocation =
				get(CarrierDetailSummary.class, uri("/statistics/carrier-detail-summary"))
						.param("domain_name", domainName)
						.param("stat_type", statType)
						.param("carrier", carrier);

		if (startTime != null) {
			carrierDetailSummaryInvocation = carrierDetailSummaryInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			carrierDetailSummaryInvocation = carrierDetailSummaryInvocation.param("end_time", endTime);
		}
		if (enterpriseProjectId != null) {
			carrierDetailSummaryInvocation = carrierDetailSummaryInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return carrierDetailSummaryInvocation.execute(this.buildExecutionOptions(CarrierDetailSummary.class));
	}

	/**
	 * Querying Top 100 urls summary
	 *
	 * @param domainName
	 * @param statType
	 * @param startTime
	 * @param endTime
	 * @param serviceArea
	 * @return {@link TopUrlsSummary} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public TopUrlsSummary queryTopUrlsSummary(String domainName,
											  String statType,
											  Long startTime,
											  Long endTime,
											  String serviceArea,
											  String enterpriseProjectId) throws ServerCdnErrorResponseException {

		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(statType, "parameter `statType` should not be null");

		Invocation<TopUrlsSummary> topUrlsSummaryInvocation =
				get(TopUrlsSummary.class, uri("/statistics/top-url"))
						.param("domain_name", domainName)
						.param("stat_type", statType);

		if (startTime != null) {
			topUrlsSummaryInvocation = topUrlsSummaryInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			topUrlsSummaryInvocation = topUrlsSummaryInvocation.param("end_time", endTime);
		}
		if (serviceArea != null) {
			topUrlsSummaryInvocation = topUrlsSummaryInvocation.param("service_area", serviceArea);
		}
		if (enterpriseProjectId != null) {
			topUrlsSummaryInvocation = topUrlsSummaryInvocation.param("enterprise_project_id", enterpriseProjectId);
		}
		return topUrlsSummaryInvocation.execute(this.buildExecutionOptions(TopUrlsSummary.class));
	}

	/**
	 * Querying region carrier domain consumption
	 *
	 * @param domainName
	 * @param statType
	 * @param region
	 * @param carrier
	 * @param startTime
	 * @param endTime
	 * @return {@link RegionCarrierDomainSummary} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public RegionCarrierDomainSummary queryRegionCarrierDomainSummary(String domainName,
																	  String statType,
																	  String region,
																	  String carrier,
																	  Long startTime,
																	  Long endTime,
																	  String enterpriseProjectId) throws ServerCdnErrorResponseException {

		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(statType, "parameter `statType` should not be null");
		Preconditions.checkNotNull(region, "parameter `region` should not be null");
		Preconditions.checkNotNull(carrier, "parameter `carrier` should not be null");

		Invocation<RegionCarrierDomainSummary> regionCarrierDomainSummaryInvocation =
				get(RegionCarrierDomainSummary.class, uri("/statistics/region-carrier-domain"))
						.param("domain_name", domainName)
						.param("stat_type", statType)
						.param("region", region)
						.param("carrier", carrier);

		if (startTime != null) {
			regionCarrierDomainSummaryInvocation = regionCarrierDomainSummaryInvocation.param("start_time", startTime);
		}
		if (endTime != null) {
			regionCarrierDomainSummaryInvocation = regionCarrierDomainSummaryInvocation.param("end_time", endTime);
		}
		if (enterpriseProjectId != null) {
			regionCarrierDomainSummaryInvocation = regionCarrierDomainSummaryInvocation.param("enterprise_project_id", enterpriseProjectId);
		}

		return regionCarrierDomainSummaryInvocation.execute(this.buildExecutionOptions(RegionCarrierDomainSummary.class));

	}

	/**
	 * Querying region carrier detail consumption
	 *
	 * @param domainName
	 * @param statType
	 * @param region
	 * @param carrier
	 * @param startTime
	 * @param endTime
	 * @param interval
	 * @return {@link RegionCarrierDetail} instance
	 * @throws ServerCdnErrorResponseException
	 */
	public RegionCarrierDetail queryRegionCarrierDetail(String domainName,
														String statType,
														String region,
														String carrier,
														Long startTime,
														Long endTime,
														Integer interval,
														String enterpriseProjectId) throws ServerCdnErrorResponseException {

		Preconditions.checkNotNull(domainName, "parameter `domainName` should not be null");
		Preconditions.checkNotNull(statType, "parameter `statType` should not be null");
		Preconditions.checkNotNull(region, "parameter `region` should not be null");
		Preconditions.checkNotNull(carrier, "parameter `carrier` should not be null");

		Invocation<RegionCarrierDetail> regionCarrierDetailInvocation =
				get(RegionCarrierDetail.class, uri("/statistics/region-carrier-detail"))
						.param("domain_name", domainName)
						.param("stat_type", statType)
						.param("region", region)
						.param("carrier", carrier);

		if (startTime != null) {
			regionCarrierDetailInvocation = regionCarrierDetailInvocation.param("start_time", startTime);
		}

		if (endTime != null) {
			regionCarrierDetailInvocation = regionCarrierDetailInvocation.param("end_time", endTime);
		}

		if (interval != null) {
			regionCarrierDetailInvocation = regionCarrierDetailInvocation.param("interval", interval);
		}

		if (enterpriseProjectId != null) {
			regionCarrierDetailInvocation = regionCarrierDetailInvocation.param("enterprise_project_id", enterpriseProjectId);
		}

		return regionCarrierDetailInvocation.execute(this.buildExecutionOptions(RegionCarrierDetail.class));

	}
}
