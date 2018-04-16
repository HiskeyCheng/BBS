<#macro html page_title page_tab="">
<!doctype html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <#if site.googleZZ??>
    <meta name="google-site-verification" content="${site.googleZZ}" />
  </#if>
  <#if site.baiduZZ??>
    <meta name="baidu-site-verification" content="${site.baiduZZ}" />
  </#if>
  <title>${page_title!site.name}</title>
  <link rel="shortcut icon" href="/static/favicon.svg">
  <link rel="stylesheet" href="/static/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="/static/font-awesome/css/font-awesome.min.css">
  <link rel="stylesheet" href="/static/css/app.css">

  <#if site.GA?? && site.GA != "">
    <!-- Global site tag (gtag.js) - Google Analytics -->
    <script async src="https://www.googletagmanager.com/gtag/js?id=${site.GA}"></script>
    <script>
      window.dataLayer = window.dataLayer || [];
      function gtag(){dataLayer.push(arguments);}
      gtag('js', new Date());

      gtag('config', '${site.GA}');
    </script>
  </#if>

  <#if site.baiduTJ?? && site.baiduTJ != "">
    <script>
      var _hmt = _hmt || [];
      (function() {
        var hm = document.createElement("script");
        hm.src = "https://hm.baidu.com/hm.js?${site.baiduTJ}";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
      })();
    </script>
  </#if>

  <script src="/static/js/jquery.min.js"></script>
  <script src="/static/bootstrap/js/bootstrap.min.js"></script>
  <script type="text/javascript" src="/static/js/canvas-particle.js"></script>
  <script>
    $(function () {
      var n = $("#goTop");
      n.click(function () {
        return $("html,body").animate({
          scrollTop: 0
        });
      });
    });
    window.onload = function() {
        //配置
        var config = {
            vx: 4,	//小球x轴速度,正为右，负为左
            vy: 4,	//小球y轴速度
            height: 2,	//小球高宽，其实为正方形，所以不宜太大
            width: 2,
            count: 200,		//点个数
            color: "121, 162, 185", 	//点颜色
            stroke: "147, 112, 219", 		//线条颜色
            dist: 6000, 	//点吸附距离
            e_dist: 20000, 	//鼠标吸附加速距离
            max_conn: 10 	//点到点最大连接数
        }

        //调用
        CanvasParticle(config);
    }
  </script>
</head>
<body>
<div class="wrapper" id="mydiv">
  <#include "./header.ftl">
  <@header page_tab=page_tab/>
  <div class="container" style="padding: 0 25px;">
    <form class="hidden-lg hidden-md" style="margin: 0 -10px;" role="search" action="/search" method="get">
      <div class="form-group has-feedback" style="margin-bottom: 10px;">
        <input type="text" class="form-control" name="q" value="${q!}" placeholder="回车搜索">
        <span class="glyphicon glyphicon-search form-control-feedback" aria-hidden="true"></span>
      </div>
    </form>
    <#nested />
  </div>
</div>
  <#include "./footer.ftl">
  <@footer/>
</body>
</html>
</#macro>