package cn.itcast;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.net.InetAddress;

/**
 * @创建人 健程大佬
 * @创建时间 2019/8/18    10:02
 * @描述
 */
public class EsManager {
    private TransportClient client =null;
    @Before
    public void init() throws Exception{
//        初始化客户端，此代码是官网提供
        client = new PreBuiltTransportClient(Settings.EMPTY)
                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
    }

    @Test
    public void testSearch(){
        SearchResponse response = client.prepareSearch("heima") //指定索引库
                .setQuery(QueryBuilders.termQuery("goodsName", "手机"))




                .get();
        SearchHits searchHits = response.getHits();
        System.out.println("查询总条数"+searchHits.getTotalHits());
        SearchHit[] hits = searchHits.getHits();
        for (SearchHit hit : hits) {
            String sourceAsString = hit.getSourceAsString();
            System.out.println(sourceAsString);
        }
    }
    //    客户端关闭
    @After
    public void end(){
        client.close();
    }

}
