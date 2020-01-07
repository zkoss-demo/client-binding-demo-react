module.exports = function override(config, env) {
	config.optimization.splitChunks = {
		cacheGroups: {
			default: false,
		}
	};
	config.optimization.runtimeChunk = false;
	config.output.filename = 'bundle.js';
	return config;
};
