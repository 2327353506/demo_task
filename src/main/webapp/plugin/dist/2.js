webpackJsonp([2],{188:function(t,e,n){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var i=n(191),r=n(195),o=n(79),u=o(i.a,r.a,!1,null,null,null);e.default=u.exports},191:function(t,e,n){"use strict";e.a={data:function(){return{url:"",height:"0px",width:"0px"}},created:function(){this.url=this.$store.state.root+"/druid"},methods:{onChangeHeight:function(){this.height=document.documentElement.clientHeight-55+"px",this.width=document.documentElement.clientWidth-250+"px"}}}},195:function(t,e,n){"use strict";var i=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("div",[n("iframe",{staticStyle:{overflow:"hidden"},attrs:{src:t.url,width:t.width,height:t.height,frameborder:"0",scrolling:"”auto”"},on:{load:t.onChangeHeight}})])},r=[],o={render:i,staticRenderFns:r};e.a=o}});
//# sourceMappingURL=2.js.map?d0d05786da197603942c