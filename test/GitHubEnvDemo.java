package test;

/**
 * 演示如何在 Coder 中通过环境变量配置 GitHub 仓库信息
 * 
 * 使用说明：
 * 1. 在 Coder 中关联 GitHub 仓库后，设置以下环境变量：
 *    - GITHUB_REPO: GitHub 仓库名称 (例如：my-awesome-project)
 *    - GITHUB_OWNER: GitHub 用户名或组织名 (例如：octocat)
 *    - GITHUB_TOKEN: GitHub API Token (用于认证)
 *    - GITHUB_BRANCH: 分支名称 (例如：main 或 master)
 * 
 * 2. 这些环境变量会在运行时自动注入到 Java 程序中
 * 3. 通过 System.getenv() 方法读取环境变量
 */
public class GitHubEnvDemo {
    
    public static void main(String[] args) {
        // 从环境变量中读取 GitHub 配置信息
        String githubRepo = System.getenv("GITHUB_REPO");
        String githubOwner = System.getenv("GITHUB_OWNER");
        String githubToken = System.getenv("GITHUB_TOKEN");
        String githubBranch = System.getenv("GITHUB_BRANCH");
        
        // 输出配置信息
        System.out.println("=== GitHub 仓库配置信息 ===");
        
        if (githubOwner != null && !githubOwner.isEmpty()) {
            System.out.println("仓库所有者: " + githubOwner);
        } else {
            System.out.println("仓库所有者: [未设置 GITHUB_OWNER 环境变量]");
        }
        
        if (githubRepo != null && !githubRepo.isEmpty()) {
            System.out.println("仓库名称: " + githubRepo);
        } else {
            System.out.println("仓库名称: [未设置 GITHUB_REPO 环境变量]");
        }
        
        if (githubBranch != null && !githubBranch.isEmpty()) {
            System.out.println("分支名称: " + githubBranch);
        } else {
            System.out.println("分支名称: [未设置 GITHUB_BRANCH 环境变量] (默认使用 main)");
        }
        
        if (githubToken != null && !githubToken.isEmpty()) {
            // 为了安全，只显示 token 的前几位和后几位
            String maskedToken = maskToken(githubToken);
            System.out.println("API Token: " + maskedToken);
        } else {
            System.out.println("API Token: [未设置 GITHUB_TOKEN 环境变量]");
        }
        
        // 构建完整的仓库 URL
        if (githubOwner != null && githubRepo != null) {
            String repoUrl = buildGitHubUrl(githubOwner, githubRepo, githubBranch);
            System.out.println("\n仓库完整URL: " + repoUrl);
        }
        
        System.out.println("=========================");
        
        // 示例：如何使用这些配置调用 GitHub API
        demonstrateGitHubApiUsage(githubOwner, githubRepo, githubToken, githubBranch);
    }
    
    /**
     * 遮蔽敏感信息，只显示 token 的前后几位
     */
    private static String maskToken(String token) {
        if (token.length() <= 8) {
            return "***";
        }
        return token.substring(0, 4) + "..." + token.substring(token.length() - 4);
    }
    
    /**
     * 构建 GitHub 仓库 URL
     */
    private static String buildGitHubUrl(String owner, String repo, String branch) {
        String safeBranch = (branch != null && !branch.isEmpty()) ? branch : "main";
        return String.format("https://github.com/%s/%s/tree/%s", owner, repo, safeBranch);
    }
    
    /**
     * 演示如何使用这些环境变量调用 GitHub API
     * 实际项目中可以替换为真实的 HTTP 请求
     */
    private static void demonstrateGitHubApiUsage(String owner, String repo, String token, String branch) {
        System.out.println("\n=== GitHub API 使用示例 ===");
        
        if (owner == null || repo == null) {
            System.out.println("缺少必要的环境变量，无法调用 GitHub API");
            return;
        }
        
        // 示例：构建 API 请求头
        System.out.println("API 请求示例:");
        System.out.println("GET https://api.github.com/repos/" + owner + "/" + repo);
        
        if (token != null && !token.isEmpty()) {
            System.out.println("Headers:");
            System.out.println("  Authorization: Bearer " + maskToken(token));
            System.out.println("  Accept: application/vnd.github.v3+json");
        }
        
        // 示例：获取特定分支信息
        String safeBranch = (branch != null && !branch.isEmpty()) ? branch : "main";
        System.out.println("\n获取分支 '" + safeBranch + "' 的信息:");
        System.out.println("GET https://api.github.com/repos/" + owner + "/" + repo + "/branches/" + safeBranch);
        
        System.out.println("\n提示：在实际项目中，可以使用 HttpURLConnection 或 HttpClient 发送真实请求");
        System.out.println("=========================");
    }
}
