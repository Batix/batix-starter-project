module.exports = {
  publicPath: process.env.VUE_APP_PUBLIC_PATH,
  css: {
    sourceMap: process.env.NODE_ENV === 'production' ? false : true
  },
  runtimeCompiler: true,
  transpileDependencies: [
    'ansi-regex'
  ]
};
