git参考资料：
http://www.zhihu.com/question/20070065
http://wenku.baidu.com/link?url=CJpap1oRxILVELbyRY6eX0DLExGS4Z5MjaMQJ2H45Bz1c1jLCd7jNugfHmNwvOK2wSHpblUiItuW6r-FHXfoRyViOv_APOHzpXxQrxJImwW
http://blog.csdn.net/w13770269691/article/details/38704933


#下载项目
git clone https://github.com/wanglianghust/autocode

#创建本地分支
git branch 分支名

#创建本地分支,并切换到了该分支
git checout -b 分支名

#切换分支
git checkout 分支名

#上传分支到服务器
git push origin 分支名


#上传文件
git add .
git commit
:q!
git push


1.首先在idea上创建本地仓库
2.在通过命令从idea提交代码到github
  1.在Github上建立仓库
  2.在本地配置远程仓库

    #连接需要上传的地址
    git remote add origin 你项目的地址(git remote add origin https://github.com/wanglianghust/javatest)
    #上传
    git push -u origin master
    #下载
    git pull origin master



合并分支
法一：
       git merge “注释” 合并的目标分支 合并的来源分支
如果合并有冲突，git会有提示。
例如：git checkout master   （切换到master分支）
       git merge HEAD dev~2 (合并master分支和dev~2分支)或者：git merge master dev~2
法二：
       git pull 合并的目标分支 合并的来源分支
例如: git checkout master （切换到master分支）
       git pull . dev~2（合并当前分支和dev~2分支）