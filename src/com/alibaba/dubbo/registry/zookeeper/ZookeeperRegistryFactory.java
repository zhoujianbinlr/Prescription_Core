/*
 * Copyright 1999-2011 Alibaba Group.
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 *      http://www.apache.org/licenses/LICENSE-2.0
 *  
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.dubbo.registry.zookeeper;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.registry.Registry;
import com.alibaba.dubbo.registry.support.AbstractRegistryFactory;
import com.alibaba.dubbo.remoting.zookeeper.ZookeeperTransporter;
import com.alibaba.dubbo.remoting.zookeeper.zkclient.ZkclientZookeeperTransporter;

/**
 * ZookeeperRegistryFactory.
 * 
 * @author william.liangf
 */
public class ZookeeperRegistryFactory extends AbstractRegistryFactory {

	private ZookeeperTransporter zookeeperTransporter;

	public void setZookeeperTransporter(ZookeeperTransporter zookeeperTransporter) {
		this.zookeeperTransporter = zookeeperTransporter;
	}

	@Override
	public Registry createRegistry(URL url) {
		if (zookeeperTransporter == null) {
			zookeeperTransporter = new ZkclientZookeeperTransporter();
		}
		return new ZookeeperRegistry(url, zookeeperTransporter);
	}

}