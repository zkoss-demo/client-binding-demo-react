module.exports = {
  webpack: function override(config, env) {
    config.optimization.splitChunks = {
      cacheGroups: {
        default: false,
      }
    };
    config.optimization.runtimeChunk = false;
    config.output.filename = 'bundle.js';
    return config;
  },
  devServer: function(configFunction) {
    return function(proxy, allowedHost) {
      const config = configFunction(proxy, allowedHost);
      config.proxy = { '/': 'http://localhost:8080/' };
      return config;
    };
  }
}
