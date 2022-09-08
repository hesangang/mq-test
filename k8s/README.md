# 说明文档
[文档地址](http://t.csdn.cn/8PsMx)
## 自动创建redis集群，构成3主3从集群模式
> kubectl exec -it redis-sts-0 -- redis-cli -a 123456 --cluster create --cluster-replicas 1 $(kubectl get pods -l app=redis-sts -o jsonpath='{range.items[*]}{.status.podIP}:6379 {end}')

## 检查集群信息
> kubectl exec -it redis-sts-0 -- redis-cli -a 123456--cluster check  $(kubectl get pods -l app=redis-sts -o jsonpath='{range.items[0]}{.status.podIP}:6379 {end}')

> kubectl  get pods -l app=redis-sts -o wide

