const base = {
    get() {
        return {
            url : "http://localhost:8080/nestchildrenandelderly/",
            name: "nestchildrenandelderly",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/nestchildrenandelderly/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "关爱空巢老人小孩平台"
        } 
    }
}
export default base
