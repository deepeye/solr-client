package org.jzp.code.solr.client.test;

import com.google.common.collect.Lists;
import org.jzp.code.solr.client.loadstrategic.RandomLoadBalance;
import org.apache.solr.client.solrj.SolrServer;
import org.junit.Assert;
import org.junit.Test;
import org.jzp.code.solr.client.test.mock.MockSolrServer;

import java.util.List;

/**
 * RandomLoadBalance测试类
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-03-31
 */
public class RandomLoadBalanceTest {

    @Test
    public void testSelect() {
        RandomLoadBalance loadBalance = new RandomLoadBalance();
        List<SolrServer> dataSources = Lists.newArrayList();
        dataSources.add(new MockSolrServer());
        dataSources.add(new MockSolrServer());
        dataSources.add(new MockSolrServer());
        dataSources.add(new MockSolrServer());
        dataSources.add(new MockSolrServer());
        SolrServer ds = loadBalance.select(dataSources);
        Assert.assertNotNull(ds);
    }

    @Test(expected = RuntimeException.class)
    public void testSelectWithEmptyDSs() {
        RandomLoadBalance loadBalance = new RandomLoadBalance();
        List<SolrServer> dataSources = Lists.newArrayList();
        loadBalance.select(dataSources);
    }

    @Test(expected = RuntimeException.class)
    public void testSelectWithNullDSs() {
        RandomLoadBalance loadBalance = new RandomLoadBalance();
        List<SolrServer> dataSources = null;
        loadBalance.select(dataSources);
    }

    @Test
    public void testSelectWithOneDS() {
        RandomLoadBalance loadBalance = new RandomLoadBalance();
        List<SolrServer> dataSources = Lists.newArrayList();
        dataSources.add(new MockSolrServer());
        SolrServer ds = loadBalance.select(dataSources);
        Assert.assertNotNull(ds);
    }
}
