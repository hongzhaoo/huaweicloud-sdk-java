/*******************************************************************************
 * 	Copyright 2016 ContainX and OpenStack4j                                          
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
package com.huawei.openstack4j.openstack.ecs.v1_1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.huawei.openstack4j.model.ModelEntity;
import com.huawei.openstack4j.openstack.ecs.v1.contants.NetworkChargingMode;
import com.huawei.openstack4j.openstack.ecs.v1.contants.VolumeType;
import com.huawei.openstack4j.openstack.ecs.v1_1.contants.ShareType;
import com.huawei.openstack4j.openstack.ecs.v1_1.domain.Bandwidth.BandwidthBuilder;

/**
 * Model represent attributes of Server Data Volume
 *
 * @author QianBiao.NG
 * @date   2017-07-31 11:12:39
 */
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataVolume implements ModelEntity {

	private static final long serialVersionUID = 5294355671374520846L;

	/**
	 * 云服务器系统盘对应的磁盘类型，需要与系统所提供的磁盘类型相匹配。
		SATA：普通IO磁盘类型。
		SAS：高IO磁盘类型。
		SSD：超高IO磁盘类型。
		co-pl：高IO (性能优化Ⅰ型)
		uh-l1：超高IO (时延优化)
	 */
	@JsonProperty("volumetype")
	VolumeType type;

	/**
	 * 系统盘大小，容量单位为GB， 输入大小范围为[1,1024]。
		约束：
		系统盘大小取值应不小于镜像支持的系统盘的最小值(镜像的min_disk属性)。
		若该参数没有指定或者指定为0，系统盘大小默认取值为镜像中系统盘的最小值(镜像的min_disk属性)。
	 */
	@JsonProperty("size")
	Integer size;

	/**
	 * 创建共享磁盘的信息。
		true：创建的磁盘为共享盘。
		false：创建的磁盘为普通云硬盘。
	 */
	@JsonProperty("multiattach")
	Boolean multiAttach;

	/**
	 * 数据卷是否使用SCSI锁。
	 * 如果使用，请将该字段值配置为“true”，否则，请勿填写该字段。
	 */
	@JsonProperty("hw:passthrough")
	Boolean passthrough;

	/**
	 * 磁盘的产品信息。
	 */
	@JsonProperty("extendparam")
	VolumeExtendParam extendParam;
	
}
