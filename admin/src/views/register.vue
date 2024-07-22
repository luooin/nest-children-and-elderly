<template>
	<div>
		<div class="container"
			:style='{ "minHeight": "100vh", "alignItems": "center", "display": "flex", "width": "100%", "backgroundSize": "cover", "backgroundPosition": "center center", "backgroundRepeat": "no-repeat", "justifyContent": "center" }'>
			<el-form v-if="pageFlag == 'register'"
				:style='{ "border": "0px solid #f6f6f6", "padding": "20px 100px 40px", "margin": "0 2% 0 60%", "alignItems": "flex-start", "textAlign": "center", "display": "block", "justifyContent": "flex-start", "minHeight": "622px", "borderRadius": "0px", "flexWrap": "wrap", "background": "#fff", "width": "33%", "position": "relative", "height": "auto" }'
				ref="rgsForm" class="rgs-form" :model="rgsForm" :rules="rules">
				<div v-if="true"
					:style='{ "padding": "0 0 10px", "margin": "0 0 10px", "borderColor": "#ff8b1e", "color": "#b98b5f", "textAlign": "center", "display": "inline-block", "background": "none", "borderWidth": "0 0 1px", "width": "100%", "lineHeight": "40px", "fontSize": "24px", "borderStyle": "solid", "fontWeight": "500" }'
					class="title">关爱空巢老人小孩平台注册</div>
				<el-form-item
					:style='{ "padding": "0 0px", "margin": "0 20px 0", "textAlign": "left", "flexWrap": "wrap", "display": "flex", "width": "100%", "fontSize": "inherit", "position": "relative", "height": "auto" }'
					class="list-item" v-if="tableName == 'yonghu'">
					<div v-if="true"
						:style='{ "padding": "0 6px", "color": "#b98b5f", "textAlign": "right", "left": "-120px", "display": "inline-block", "width": "120px", "lineHeight": "40px", "fontSize": "14px", "position": "absolute", "order": "2" }'
						class="lable" :class="changeRules('yonghuzhanghao') ? 'required' : ''">用户账号：</div>
					<el-input v-model="ruleForm.yonghuzhanghao" autocomplete="off" placeholder="用户账号" type="text" />
				</el-form-item>
				<el-form-item
					:style='{ "padding": "0 0px", "margin": "0 20px 0", "textAlign": "left", "flexWrap": "wrap", "display": "flex", "width": "100%", "fontSize": "inherit", "position": "relative", "height": "auto" }'
					class="list-item" v-if="tableName == 'yonghu'">
					<div v-if="true"
						:style='{ "padding": "0 6px", "color": "#b98b5f", "textAlign": "right", "left": "-120px", "display": "inline-block", "width": "120px", "lineHeight": "40px", "fontSize": "14px", "position": "absolute", "order": "2" }'
						class="lable" :class="changeRules('mima') ? 'required' : ''">密码：</div>
					<el-input v-model="ruleForm.mima" autocomplete="off" placeholder="密码" type="password" />
				</el-form-item>
				<el-form-item
					:style='{ "padding": "0 0px", "margin": "0 20px 0", "textAlign": "left", "flexWrap": "wrap", "display": "flex", "width": "100%", "fontSize": "inherit", "position": "relative", "height": "auto" }'
					class="list-item" v-if="tableName == 'yonghu'">
					<div v-if="true"
						:style='{ "padding": "0 6px", "color": "#b98b5f", "textAlign": "right", "left": "-120px", "display": "inline-block", "width": "120px", "lineHeight": "40px", "fontSize": "14px", "position": "absolute", "order": "2" }'
						class="lable" :class="changeRules('mima') ? 'required' : ''">确认密码：</div>
					<el-input v-model="ruleForm.mima2" autocomplete="off" placeholder="确认密码" type="password" />
				</el-form-item>
				<el-form-item
					:style='{ "padding": "0 0px", "margin": "0 20px 0", "textAlign": "left", "flexWrap": "wrap", "display": "flex", "width": "100%", "fontSize": "inherit", "position": "relative", "height": "auto" }'
					class="list-item" v-if="tableName == 'yonghu'">
					<div v-if="true"
						:style='{ "padding": "0 6px", "color": "#b98b5f", "textAlign": "right", "left": "-120px", "display": "inline-block", "width": "120px", "lineHeight": "40px", "fontSize": "14px", "position": "absolute", "order": "2" }'
						class="lable" :class="changeRules('yonghuxingming') ? 'required' : ''">用户姓名：</div>
					<el-input v-model="ruleForm.yonghuxingming" autocomplete="off" placeholder="用户姓名" type="text" />
				</el-form-item>
				<el-form-item
					:style='{ "padding": "0 0px", "margin": "0 20px 0", "textAlign": "left", "flexWrap": "wrap", "display": "flex", "width": "100%", "fontSize": "inherit", "position": "relative", "height": "auto" }'
					class="list-item" v-if="tableName == 'yonghu'">
					<div v-if="true"
						:style='{ "padding": "0 6px", "color": "#b98b5f", "textAlign": "right", "left": "-120px", "display": "inline-block", "width": "120px", "lineHeight": "40px", "fontSize": "14px", "position": "absolute", "order": "2" }'
						class="lable" :class="changeRules('xingbie') ? 'required' : ''">性别：</div>
					<el-select v-model="ruleForm.xingbie" placeholder="请选择性别">
						<el-option v-for="(item, index) in yonghuxingbieOptions" v-bind:key="index" :label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item
					:style='{ "padding": "0 0px", "margin": "0 20px 0", "textAlign": "left", "flexWrap": "wrap", "display": "flex", "width": "100%", "fontSize": "inherit", "position": "relative", "height": "auto" }'
					class="list-item" v-if="tableName == 'yonghu'">
					<div v-if="true"
						:style='{ "padding": "0 6px", "color": "#b98b5f", "textAlign": "right", "left": "-120px", "display": "inline-block", "width": "120px", "lineHeight": "40px", "fontSize": "14px", "position": "absolute", "order": "2" }'
						class="lable" :class="changeRules('nianling') ? 'required' : ''">年龄：</div>
					<el-input v-model.number="ruleForm.nianling" autocomplete="off" placeholder="年龄" type="text" />
				</el-form-item>
				<el-form-item
					:style='{ "padding": "0 0px", "margin": "0 20px 0", "textAlign": "left", "flexWrap": "wrap", "display": "flex", "width": "100%", "fontSize": "inherit", "position": "relative", "height": "auto" }'
					class="list-item" v-if="tableName == 'yonghu'">
					<div v-if="true"
						:style='{ "padding": "0 6px", "color": "#b98b5f", "textAlign": "right", "left": "-120px", "display": "inline-block", "width": "120px", "lineHeight": "40px", "fontSize": "14px", "position": "absolute", "order": "2" }'
						class="lable" :class="changeRules('shoujihaoma') ? 'required' : ''">手机号码：</div>
					<el-input v-model="ruleForm.shoujihaoma" autocomplete="off" placeholder="手机号码" type="text" />
				</el-form-item>
				<el-form-item
					:style='{ "padding": "0 0px", "margin": "0 20px 0", "textAlign": "left", "flexWrap": "wrap", "display": "flex", "width": "100%", "fontSize": "inherit", "position": "relative", "height": "auto" }'
					class="list-item" v-if="tableName == 'yonghu'">
					<div v-if="true"
						:style='{ "padding": "0 6px", "color": "#b98b5f", "textAlign": "right", "left": "-120px", "display": "inline-block", "width": "120px", "lineHeight": "40px", "fontSize": "14px", "position": "absolute", "order": "2" }'
						class="lable" :class="changeRules('touxiang') ? 'required' : ''">头像：</div>
					<file-upload tip="点击上传头像" action="file/upload" :limit="3" :multiple="true"
						:fileUrls="ruleForm.touxiang ? ruleForm.touxiang : ''"
						@change="yonghutouxiangUploadChange"></file-upload>
				</el-form-item>
				<button
					:style='{ "border": "0px solid #4FA1D9", "cursor": "pointer", "padding": "0 24px", "boxShadow": "0 0 0px rgba(64, 158, 255, .5)", "margin": "20px 0px 0 0", "color": "#000", "display": "inline-block", "letterSpacing": "4px", "float": "right", "outline": "none", "borderRadius": "0px", "background": "#ff8b1e", "width": "auto", "fontSize": "16px", "height": "40px" }'
					type="button" class="r-btn" @click="login()">注册</button>
				<div :style='{ "cursor": "pointer", "padding": "0", "margin": "20px 0 0", "color": "rgba(159, 159, 159, 1)", "textAlign": "right", "display": "inline-block", "width": "auto", "lineHeight": "44px", "fontSize": "14px" }'
					class="r-login" @click="close()">已有账号，直接登录</div>
			</el-form>

		</div>
	</div>
</template>

<script>
export default {
	data() {
		return {
			ruleForm: {
			},
			forgetForm: {},
			pageFlag: '',
			tableName: "",
			rules: {},
			yonghuxingbieOptions: [],
		};
	},
	mounted() {
		this.pageFlag = this.$route.query.pageFlag
		if (this.$route.query.pageFlag == 'register') {

			let table = this.$storage.get("loginTable");
			this.tableName = table;
			if (this.tableName == 'yonghu') {
				this.ruleForm = {
					yonghuzhanghao: '',
					mima: '',
					yonghuxingming: '',
					xingbie: '',
					nianling: '',
					shoujihaoma: '',
					touxiang: '',
				}
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuzhanghao = [{ required: true, message: '请输入用户账号', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.mima = [{ required: true, message: '请输入密码', trigger: 'blur' }]
			}
			if ('yonghu' == this.tableName) {
				this.rules.yonghuxingming = [{ required: true, message: '请输入用户姓名', trigger: 'blur' }]
			}
			this.yonghuxingbieOptions = "男,女".split(',')
		}
	},
	created() {
	},
	destroyed() {
	},
	methods: {
		changeRules(name) {
			if (this.rules[name]) {
				return true
			}
			return false
		},
		// 获取uuid
		getUUID() {
			return new Date().getTime();
		},
		close() {
			this.$router.push({ path: "/login" });
		},
		yonghutouxiangUploadChange(fileUrls) {
			this.ruleForm.touxiang = fileUrls;
		},

		// 多级联动参数


		// 注册
		login() {
			var url = this.tableName + "/register";
			if ((!this.ruleForm.yonghuzhanghao) && `yonghu` == this.tableName) {
				this.$message.error(`用户账号不能为空`);
				return
			}
			if ((!this.ruleForm.mima) && `yonghu` == this.tableName) {
				this.$message.error(`密码不能为空`);
				return
			}
			if ((this.ruleForm.mima != this.ruleForm.mima2) && `yonghu` == this.tableName) {
				this.$message.error(`两次密码输入不一致`);
				return
			}
			if ((!this.ruleForm.yonghuxingming) && `yonghu` == this.tableName) {
				this.$message.error(`用户姓名不能为空`);
				return
			}
			if (`yonghu` == this.tableName && this.ruleForm.nianling && (!this.$validate.isIntNumer(this.ruleForm.nianling))) {
				this.$message.error(`年龄应输入整数`);
				return
			}
			if (`yonghu` == this.tableName && this.ruleForm.shoujihaoma && (!this.$validate.isMobile(this.ruleForm.shoujihaoma))) {
				this.$message.error(`手机号码应输入手机格式`);
				return
			}
			if (this.ruleForm.touxiang != null) {
				this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url, "g"), "");
			}
			this.$http({
				url: url,
				method: "post",
				data: this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "注册成功",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
.container {
	position: relative;
	background: url("http://localhost:8080/nestchildrenandelderly/upload/bg.jpg");

	.el-date-editor.el-input {
		width: 100%;
	}

	.rgs-form .el-input /deep/ .el-input__inner {
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 14px;
		border-color: #ff8b1e50;
		border-width: 0 0 1px;
		border-style: solid;
		min-width: 21vw;
		height: 44px;
	}

	.rgs-form .el-select /deep/ .el-input__inner {
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 14px;
		border-color: #ff8b1e50;
		border-width: 0 0 1px;
		border-style: solid;
		min-width: 21vw;
		height: 44px;
	}

	.rgs-form .el-date-editor /deep/ .el-input__inner {
		border-radius: 0px;
		padding: 0 10px 0 30px;
		margin: 0 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 14px;
		border-color: #ff8b1e50;
		border-width: 0 0 1px;
		border-style: solid;
		min-width: 21vw;
		height: 44px;
	}

	.rgs-form .el-date-editor /deep/ .el-input__inner {
		border-radius: 0px;
		padding: 0 10px 0 30px;
		margin: 0 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 14px;
		border-color: #ff8b1e50;
		border-width: 0 0 1px;
		border-style: solid;
		min-width: 21vw;
		height: 44px;
	}

	.rgs-form /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}

	.rgs-form /deep/ .upload .upload-img {
		border: 1px solid #ff8b1e50;
		cursor: pointer;
		border-radius: 0px;
		color: #ff8b1e;
		background: none;
		font-weight: 600;
		width: 90px;
		font-size: 18px;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}

	.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #ff8b1e50;
		cursor: pointer;
		border-radius: 0px;
		color: #ff8b1e;
		background: none;
		font-weight: 600;
		width: 90px;
		font-size: 18px;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}

	.rgs-form /deep/ .el-upload .el-icon-plus {
		border: 1px solid #ff8b1e50;
		cursor: pointer;
		border-radius: 0px;
		color: #ff8b1e;
		background: none;
		font-weight: 600;
		width: 90px;
		font-size: 18px;
		line-height: 44px;
		text-align: center;
		height: 44px;
	}
}

.required {
	position: relative;
}

.required::after {
	color: red;
	position: absolute;
	right: 3px;
	content: "*";
	order: 3;
}

.editor>.avatar-uploader {
	line-height: 0;
	height: 0;
}
</style>
