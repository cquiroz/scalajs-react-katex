const path = require("path");
const merge = require("webpack-merge");
const commonConfig = require("./webpack.common");
const Webpack = require("webpack");
const HtmlWebpackPlugin = require("html-webpack-plugin");
const parts = require("./webpack.parts");

const publicFolderName = "../docs";

const productionConfig = merge(
  parts.extractCSS({ use: ["css-loader", parts.autoprefix()] }),
  parts.minifyCSS({
    options: {
      discardComments: {
        removeAll: true
      },
      // Run cssnano in safe mode to avoid
      // potentially unsafe transformations.
      safe: true
    }
  }),
  {
    mode: "production",
    entry: {
      app: [path.resolve(parts.resourcesDir, "./app.js")]
    },
    module: {
      rules: [
        {
          test: /\.(ttf|eot|woff|woff2)$/,
          use: {
            loader: "file-loader",
            options: {
              name: "fonts/[name].[ext]"
            }
          }
        }
      ]
    },
    output: {
      filename: "[name].[chunkhash].js",
      path: path.resolve(parts.rootDir, publicFolderName),
      publicPath: "/scalajs-react-katex"
      // libraryTarget: "umd"
    },
    // output: {
    //   app: [path.resolve(parts.resourcesDir, "./app.js")]
    // },
    plugins: [
      new HtmlWebpackPlugin({
        title: "ScalaJS Katex Demo",
        filename: "index.html",
        chunks: ["app"]
      })
    ]
  }
);

module.exports = merge(commonConfig, productionConfig);
