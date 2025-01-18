config.module.rules.push({
  test: /\.svg$/,
  use: [
    {
      loader: '@svgr/webpack',
      options: {
        // optional SVGR config
        // e.g. icon: true
      }
    },
    {
      // fallback to file-loader for any direct usage (non-component usage)
      loader: 'file-loader',
      options: {
        name: '[name].[hash].[ext]',
      }
    }
  ]
});
