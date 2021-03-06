package org.jzp.code.solr.client.test;

import com.google.common.collect.Lists;
import org.jzp.code.solr.client.loadstrategic.PollLoadBalance;
import org.apache.solr.client.solrj.SolrServer;
import org.junit.Assert;
import org.junit.Test;
import org.jzp.code.solr.client.test.mock.MockSolrServer;

import java.util.List;

/**
 * PollLoadBalance测试类
 *
 * @author jiazhipeng
 * @version 1.0
 * @date 2016-03-31
 */
public class PollLoadBalanceTest {

    @Test
    public void testSelect() {
        PollLoadBalance loadBalance = new PollLoadBalance();
        List<SolrServer> dataSources = Lists.newArrayList();
        dataSources.add(new MockSolrServer());
        dataSources.add(new MockSolrServer());
        dataSources.add(new MockSolrServer());
        dataSources.add(new MockSolrServer());
        dataSources.add(new MockSolrServer());
        SolrServer ds1 = loadBalance.select(dataSources);
        SolrServer ds2 = loadBalance.select(dataSources);
        Assert.assertNotNull(ds1);
        Assert.assertNotNull(ds2);
    }

    @Test(expected = RuntimeException.class)
    public void testSelectWithEmptyDSs() {
        PollLoadBalance loadBalance = new PollLoadBalance();
        List<SolrServer> dataSources = Lists.newArrayList();
        loadBalance.select(dataSources);
    }

    @Test(expected = RuntimeException.class)
    public void testSelectWithNullDSs() {
        PollLoadBalance loadBalance = new PollLoadBalance();
        List<SolrServer> dataSources = null;
        loadBalance.select(dataSources);
    }

    @Test
    public void testSelectWithOneDS() {
        PollLoadBalance loadBalance = new PollLoadBalance();
        List<SolrServer> dataSources = Lists.newArrayList();
        dataSources.add(new MockSolrServer());
        SolrServer ds = loadBalance.select(dataSources);
        Assert.assertNotNull(ds);
    }
}
