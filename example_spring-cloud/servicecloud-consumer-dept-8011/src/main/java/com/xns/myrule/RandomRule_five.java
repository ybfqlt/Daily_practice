package com.xns.myrule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

/**
 * @Author: xns
 * @Date: 20-1-18 上午9:43
 */
public class RandomRule_five extends AbstractLoadBalancerRule {
    /**
     * 总共被调用的次数,目前要求每台被调用5次
     */
    private int total = 0;
    /**
     * 当前提供服务的机器号
     */
    private int currentindex = 0;
    //total需要重新置为0,但是已经达到过一个5次,我们的index=1
    //分析:5次，但是微服务只有 8001 8002 8003三台

    public Server choose(ILoadBalancer lb, Object key)
    {
        if(lb == null){
            return null;
        }
        Server server = null;
        while(server == null){
            if(Thread.interrupted()){
                return null;
            }
            List<Server> upList = lb.getReachableServers();
            List<Server> allList = lb.getAllServers();

            int serverCount = allList.size();
            if(serverCount == 0){
                return null;
            }

            if(total < 5){
                server = upList.get(currentindex);
                total++;
            }else{
                total = 0;
                currentindex++;
                if(currentindex >= upList.size()){
                    currentindex = 0;
                }
            }

            if(server == null){
                Thread.yield();
                continue;
            }
            if(server.isAlive()){
                return server;
            }
            server = null;
            Thread.yield();
        }
        return server;
    }

    @Override
    public void initWithNiwsConfig(IClientConfig iClientConfig) {

    }

    /**
     * 注意：这块调用上面的choose
     * @param o
     * @return
     */
    @Override
    public Server choose(Object o) {
        return choose(getLoadBalancer(),o);
    }
}
