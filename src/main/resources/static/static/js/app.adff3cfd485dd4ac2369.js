webpackJsonp([1],{"4Wry":function(e,t){},ARjt:function(e,t){},"C+y2":function(e,t){},EsHn:function(e,t){},HSfO:function(e,t){},NHnr:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=a("7+uW"),r={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticStyle:{"margin-top":"15px"}},[a("el-input",{staticClass:"input-with-select",attrs:{placeholder:"请输入内容"},model:{value:e.input3,callback:function(t){e.input3=t},expression:"input3"}},[a("el-select",{attrs:{slot:"prepend",placeholder:"请选择"},slot:"prepend",model:{value:e.select,callback:function(t){e.select=t},expression:"select"}},[a("el-option",{attrs:{label:"影视",value:"1"}}),e._v(" "),a("el-option",{attrs:{label:"图书",value:"2"}}),e._v(" "),a("el-option",{attrs:{label:"小组",value:"3"}})],1),e._v(" "),a("el-button",{attrs:{slot:"append",icon:"el-icon-search"},slot:"append"})],1)],1)},staticRenderFns:[]};var s=a("VU/8")({name:"pageSearch",data:function(){return{input:"",select:""}}},r,!1,function(e){a("ktUU")},null,null).exports,o=a("2bvH");n.default.use(o.a);var i={count:111,flag:window.sessionStorage.getItem("flag"),username:window.sessionStorage.getItem("username")},l={login:function(e,t){e.username=t,e.flag=!0,window.sessionStorage.setItem("username",t),window.sessionStorage.setItem("flag",!0)},logout:function(e){e.username="",e.flag=!1,window.sessionStorage.removeItem("username"),window.sessionStorage.removeItem("flag")},add:function(e){e.count++}},c=new o.a.Store({state:i,mutations:l,getter:{isLogin:function(e){return e.flag},username:function(e){return e.username}}}),u={name:"pageHeader",data:function(){return{activeIndex:"1",activeIndex2:"1",display:!0}},computed:{isLogin:function(){return 1==this.$store.state.flag},username:function(){return this.$store.state.username}},methods:{handleSelect:function(e,t){console.log(e,t)}},components:{"page-search":s},store:c},d={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{attrs:{id:"header-bar"}},[a("el-menu",{staticClass:"el-menu-demo",attrs:{"default-active":e.activeIndex,mode:"horizontal","active-text-color":"#4CAF50","background-color":"#545c64","text-color":"#fff"},on:{select:e.handleSelect}},[a("el-menu-item",{attrs:{index:"1"}},[a("a",{attrs:{href:"#/"}},[e._v("星海")])]),e._v(" "),a("el-menu-item",{attrs:{index:"2"}},[a("a",{attrs:{href:"#/movie"}},[e._v("影视")])]),e._v(" "),a("el-menu-item",{attrs:{index:"3"}},[a("a",{attrs:{href:"#/book"}},[e._v("图书")])]),e._v(" "),a("el-menu-item",{attrs:{index:"4"}},[a("a",{attrs:{href:"#/group"}},[e._v("小组")])]),e._v(" "),e.isLogin?a("div",[a("a",[a("el-button",{attrs:{round:""}},[e._v(e._s(e.$store.state.username))])],1),e._v(" "),a("a",[a("el-button",{attrs:{round:""},on:{click:function(t){return e.$store.commit("logout")}}},[e._v("注销")])],1)]):a("div",[a("a",{attrs:{href:"#/register"}},[a("el-button",{attrs:{round:""}},[e._v("注册")])],1),e._v(" "),a("a",{attrs:{href:"#/login"}},[a("el-button",{attrs:{round:""}},[e._v("登录")])],1)]),e._v(" "),a("a",[a("el-button",{attrs:{icon:"el-icon-search",circle:""}})],1)],1)],1)},staticRenderFns:[]};var m=a("VU/8")(u,d,!1,function(e){a("OnvS")},"data-v-98e856e6",null).exports,p={name:"pageShowStar",props:{value:Number}},f={render:function(){var e=this,t=e.$createElement;return(e._self._c||t)("el-rate",{attrs:{disabled:"","show-score":"","text-color":"#ff9900","score-template":"{value}"},model:{value:e.value,callback:function(t){e.value=t},expression:"value"}})},staticRenderFns:[]},v=a("VU/8")(p,f,!1,null,null,null).exports,g={name:"pageCard",data:function(){return{currentDate:new Date}},components:{"page-showstar":v}},h={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-row",e._l(4,function(t,n){return a("el-col",{key:t,attrs:{span:4,offset:n>0?1:2}},[a("el-card",{attrs:{"body-style":{padding:"0px"},shadow:"hover"}},[a("img",{staticClass:"image",attrs:{src:"https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"}}),e._v(" "),a("div",{staticStyle:{padding:"14px"}},[a("div",{staticClass:"text"},[e._v("天地灵气孕育出一颗能量巨大的混元珠，\n            元始天尊将混元珠提炼成灵珠和魔丸，灵珠投胎为人，\n            助周伐纣时可堪大用；而魔丸则会诞出魔王，为祸人间。\n            元始天尊启动了天劫咒语，3年后天雷将会降临，摧毁魔丸。\n            太乙受命将灵珠托生于陈塘关李靖家的儿子哪吒身上。\n            然而阴差阳错，灵珠和魔丸竟然被掉包。\n            本应是灵珠英雄的哪吒却成了混世大魔王。\n            调皮捣蛋顽劣不堪的哪吒却徒有一颗做英雄的心。\n            然而面对众人对魔丸的误解和即将来临的天雷的降临，\n            哪吒是否命中注定会立地成魔？他将何去何从？")]),e._v(" "),a("div",{staticClass:"bottom clearfix"},[a("div",[a("page-showstar",{attrs:{value:"4.8"}})],1),e._v(" "),a("time",{staticClass:"time"},[e._v(e._s(e.currentDate))])])])])],1)}),1)},staticRenderFns:[]};var _=a("VU/8")(g,h,!1,function(e){a("eLIt")},null,null).exports,b={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"block"},[a("span",{staticClass:"demonstration"},[e._v("区分颜色")]),e._v(" "),a("el-rate",{attrs:{colors:e.colors,"show-text":""},model:{value:e.value2,callback:function(t){e.value2=t},expression:"value2"}})],1)},staticRenderFns:[]},w=a("VU/8")({name:"pageStar",data:function(){return{value1:null,value2:null,colors:["#99A9BF","#F7BA2A","#FF9900"]}}},b,!1,null,null,null).exports,x={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-carousel",{attrs:{interval:4e3,type:"card",height:"200px"}},e._l(6,function(t){return a("el-carousel-item",{key:t},[a("h3",{staticClass:"medium"},[e._v(e._s(t))])])}),1)},staticRenderFns:[]};var $=a("VU/8")(null,x,!1,function(e){a("QiEM")},null,null).exports,y={name:"App",components:{"page-header":m,"page-search":s,"page-card":_,"page-star":w,"page-showstar":v,"page-playcard":$}},k={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("el-container",[t("el-header",[t("page-header")],1)],1),this._v(" "),t("div",[t("router-view")],1)],1)},staticRenderFns:[]};var R=a("VU/8")(y,k,!1,function(e){a("EsHn")},null,null).exports,S=a("/ocq"),F={name:"PageIndex",components:{"page-header":m,"page-search":s,"page-card":_,"page-star":w,"page-showstar":v,"page-playcard":$}},V={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"APP-index"}},[t("el-container",[t("el-main",[t("page-playcard")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1),this._v(" "),t("el-aside",{attrs:{width:"26%"}},[t("div",[t("page-search")],1)])],1)],1)},staticRenderFns:[]};var C=a("VU/8")(F,V,!1,function(e){a("ARjt")},"data-v-c50d66fc",null).exports,E={render:function(){var e=this.$createElement;return(this._self._c||e)("router-view")},staticRenderFns:[]},U=a("VU/8")(null,E,!1,null,null,null).exports,I={name:"PageBook",components:{"page-header":m,"page-search":s,"page-card":_,"page-star":w,"page-showstar":v,"page-playcard":$}},A={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"APP-book"}},[t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1)],1)],1)},staticRenderFns:[]};var q=a("VU/8")(I,A,!1,function(e){a("C+y2")},"data-v-098f3e26",null).exports,H={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("h2",[e._v(e._s(e.msg))]),e._v(" "),a("hr"),e._v(" "),a("h3",[e._v(e._s(this.$store.state.count))]),e._v(" "),a("button",{on:{click:function(t){return e.$store.commit("add")}}},[e._v("add")]),e._v(" "),a("button",{on:{click:function(t){return e.$store.commit("login","ztt")}}},[e._v("login")])])},staticRenderFns:[]},L={components:{count:a("VU/8")({name:"count",data:function(){return{msg:"Hello Vuex"}},computed:{username:function(){return this.$store.state.username}}},H,!1,null,null,null).exports},methods:{test:function(){store.commit("increment"),console.log(store.state.count)}}},D={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("div",[this._v("小组页面")]),this._v(" "),t("count")],1)},staticRenderFns:[]},P=a("VU/8")(L,D,!1,null,null,null).exports,O={name:"MovieIndex",components:{"page-header":m,"page-search":s,"page-card":_,"page-star":w,"page-showstar":v,"page-playcard":$}},M={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"movieIndex"}},[t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("page-card")],1)],1),this._v(" "),t("el-container",[t("el-main",[t("a",{attrs:{href:"#/detail"}},[t("el-button",[this._v("详情页面")])],1)])],1)],1)},staticRenderFns:[]};var N=a("VU/8")(O,M,!1,function(e){a("HSfO")},"data-v-26469a93",null).exports,j={name:"pageDetail",data:function(){return{currentDate:new Date}},components:{"page-showstar":v}},z={render:function(){var e=this.$createElement,t=this._self._c||e;return t("el-card",{attrs:{shadow:"hover"}},[t("el-row",[t("el-col",{attrs:{span:12}},[t("el-container",[t("el-main",[t("img",{staticClass:"movielogo",attrs:{src:a("wRTv")}})])],1),this._v(" "),t("el-container",[t("el-main",[t("page-showstar",{attrs:{value:"3.0"}}),this._v(" "),t("span",[this._v("电影名称")])],1)],1)],1),this._v(" "),t("el-col",{attrs:{span:10,offst:2}},[t("el-container",[t("el-main",[t("span",[this._v("电影简介")])])],1)],1)],1)],1)},staticRenderFns:[]};var B={name:"MovieDetail",components:{"page-header":m,"page-search":s,"page-card":_,"page-star":w,"page-showstar":v,"page-playcard":$,"page-detail":a("VU/8")(j,z,!1,function(e){a("4Wry")},"data-v-2aabf2c8",null).exports}},Q={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"movieDetail"}},[t("el-container",[t("page-detail")],1)],1)},staticRenderFns:[]};var T=a("VU/8")(B,Q,!1,function(e){a("nutL")},"data-v-2737ca6f",null).exports,W=a("mvHQ"),X=a.n(W),J={name:"PageLogin",data:function(){return{form:{username:"",password:""},rules:{username:[{required:!0,message:"账号不可为空",trigger:"blur"}],password:[{required:!0,message:"密码不可为空",trigger:"blur"}]},dialogVisible:!1}},methods:{onSubmit:function(e){var t=this;this.$axios.post("/login",{username:this.form.username,password:this.form.password}).then(function(e){t.responseResult=X()(e.data),200===e.data.code?(t.$store.commit("login",t.form.username),t.$router.replace({path:"/"})):alert(e.data.message)}).catch(function(e){})}}},G={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-form",{ref:"loginForm",staticClass:"login-box",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[a("h3",{staticClass:"login-title"},[e._v("请登录您的帐号")]),e._v(" "),a("el-form-item",{attrs:{label:"账号",prop:"username"}},[a("el-input",{attrs:{type:"text",placeholder:"请输入账号"},model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"密码",prop:"password"}},[a("el-input",{attrs:{type:"password",placeholder:"请输入密码"},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.onSubmit("loginForm")}}},[e._v("登录")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"温馨提示",visible:e.dialogVisible,width:"30%","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("span",[e._v("请输入账号和密码")]),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("确 定")])],1)])],1)},staticRenderFns:[]};var K=a("VU/8")(J,G,!1,function(e){a("iXtN")},"data-v-e8b6207c",null).exports,Y={name:"Register",data:function(){return{form:{username:"",password:""},rules:{username:[{required:!0,message:"账号不可为空",trigger:"blur"}],password:[{required:!0,message:"密码不可为空",trigger:"blur"}]},dialogVisible:!1}},methods:{onSubmit:function(e){var t=this;this.$axios.post("/register",{username:this.form.username,password:this.form.password}).then(function(e){t.responseResult=X()(e.data),200===e.data.code?(t.$store.commit("login",t.form.username),t.$router.replace({path:"/"})):$alert(e.data.message)}).catch(function(e){})}}},Z={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",[a("el-form",{ref:"loginForm",staticClass:"login-box",attrs:{model:e.form,rules:e.rules,"label-width":"80px"}},[a("h3",{staticClass:"login-title"},[e._v("您正在注册账号")]),e._v(" "),a("el-form-item",{attrs:{label:"账号",prop:"username"}},[a("el-input",{attrs:{type:"text",placeholder:"请输入账号"},model:{value:e.form.username,callback:function(t){e.$set(e.form,"username",t)},expression:"form.username"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"密码",prop:"password"}},[a("el-input",{attrs:{type:"password",placeholder:"请输入密码"},model:{value:e.form.password,callback:function(t){e.$set(e.form,"password",t)},expression:"form.password"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.onSubmit("loginForm")}}},[e._v("注册")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"温馨提示",visible:e.dialogVisible,width:"30%","before-close":e.handleClose},on:{"update:visible":function(t){e.dialogVisible=t}}},[a("span",[e._v("请输入账号和密码")]),e._v(" "),a("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{attrs:{type:"primary"},on:{click:function(t){e.dialogVisible=!1}}},[e._v("确 定")])],1)])],1)},staticRenderFns:[]};var ee=a("VU/8")(Y,Z,!1,function(e){a("qvOh")},"data-v-2b76f156",null).exports;n.default.use(S.a);var te=new S.a({routes:[{path:"/",name:"index",component:C},{path:"/movie",name:"movie",meta:{requireAuth:!0},component:U,children:[{path:"/",component:N},{path:"/detail",component:T}]},{path:"/book",name:"book",component:q},{path:"/group",name:"group",component:P},{path:"/login",name:"login",component:K},{path:"/register",name:"register",component:ee}]}),ae=a("zL8q"),ne=a.n(ae),re=(a("tvR6"),a("3khs")),se=a.n(re),oe=a("Muz9");oe.defaults.baseURL="http://localhost:8080/api",n.default.prototype.$axios=oe,n.default.use(se.a),n.default.use(ne.a),n.default.config.productionTip=!1,new n.default({el:"#app",router:te,components:{App:R},template:"<App/>",store:c}),te.beforeEach(function(e,t,a){return e.matched.some(function(e){return e.meta.requireAuth})?"true"!==window.sessionStorage.getItem("flag")?"login"===e.name?a():a({path:"/login"}):(a(),void c.commit("login",window.sessionStorage.getItem("username"))):("true"===window.sessionStorage.getItem("flag")&&c.commit("login",window.sessionStorage.getItem("username")),a())})},OnvS:function(e,t){},QiEM:function(e,t){},eLIt:function(e,t){},iXtN:function(e,t){},ktUU:function(e,t){},nutL:function(e,t){},qvOh:function(e,t){},tvR6:function(e,t){},wRTv:function(e,t,a){e.exports=a.p+"static/img/ci1.1f97de3.jpg"}},["NHnr"]);
//# sourceMappingURL=app.adff3cfd485dd4ac2369.js.map