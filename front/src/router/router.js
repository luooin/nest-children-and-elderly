import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import kongchaolaorenList from '../pages/kongchaolaoren/list'
import kongchaolaorenDetail from '../pages/kongchaolaoren/detail'
import kongchaolaorenAdd from '../pages/kongchaolaoren/add'
import ertongxinxiList from '../pages/ertongxinxi/list'
import ertongxinxiDetail from '../pages/ertongxinxi/detail'
import ertongxinxiAdd from '../pages/ertongxinxi/add'
import guanaihuodongList from '../pages/guanaihuodong/list'
import guanaihuodongDetail from '../pages/guanaihuodong/detail'
import guanaihuodongAdd from '../pages/guanaihuodong/add'
import canyuhuodongList from '../pages/canyuhuodong/list'
import canyuhuodongDetail from '../pages/canyuhuodong/detail'
import canyuhuodongAdd from '../pages/canyuhuodong/add'
import fuwuleixingList from '../pages/fuwuleixing/list'
import fuwuleixingDetail from '../pages/fuwuleixing/detail'
import fuwuleixingAdd from '../pages/fuwuleixing/add'
import zixunfuwuList from '../pages/zixunfuwu/list'
import zixunfuwuDetail from '../pages/zixunfuwu/detail'
import zixunfuwuAdd from '../pages/zixunfuwu/add'
import chatmessageList from '../pages/chatmessage/list'
import chatmessageDetail from '../pages/chatmessage/detail'
import chatmessageAdd from '../pages/chatmessage/add'
import friendList from '../pages/friend/list'
import friendDetail from '../pages/friend/detail'
import friendAdd from '../pages/friend/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'kongchaolaoren',
					component: kongchaolaorenList
				},
				{
					path: 'kongchaolaorenDetail',
					component: kongchaolaorenDetail
				},
				{
					path: 'kongchaolaorenAdd',
					component: kongchaolaorenAdd
				},
				{
					path: 'ertongxinxi',
					component: ertongxinxiList
				},
				{
					path: 'ertongxinxiDetail',
					component: ertongxinxiDetail
				},
				{
					path: 'ertongxinxiAdd',
					component: ertongxinxiAdd
				},
				{
					path: 'guanaihuodong',
					component: guanaihuodongList
				},
				{
					path: 'guanaihuodongDetail',
					component: guanaihuodongDetail
				},
				{
					path: 'guanaihuodongAdd',
					component: guanaihuodongAdd
				},
				{
					path: 'canyuhuodong',
					component: canyuhuodongList
				},
				{
					path: 'canyuhuodongDetail',
					component: canyuhuodongDetail
				},
				{
					path: 'canyuhuodongAdd',
					component: canyuhuodongAdd
				},
				{
					path: 'fuwuleixing',
					component: fuwuleixingList
				},
				{
					path: 'fuwuleixingDetail',
					component: fuwuleixingDetail
				},
				{
					path: 'fuwuleixingAdd',
					component: fuwuleixingAdd
				},
				{
					path: 'zixunfuwu',
					component: zixunfuwuList
				},
				{
					path: 'zixunfuwuDetail',
					component: zixunfuwuDetail
				},
				{
					path: 'zixunfuwuAdd',
					component: zixunfuwuAdd
				},
				{
					path: 'chatmessage',
					component: chatmessageList
				},
				{
					path: 'chatmessageDetail',
					component: chatmessageDetail
				},
				{
					path: 'chatmessageAdd',
					component: chatmessageAdd
				},
				{
					path: 'friend',
					component: friendList
				},
				{
					path: 'friendDetail',
					component: friendDetail
				},
				{
					path: 'friendAdd',
					component: friendAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
