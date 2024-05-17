
## تیم توسعه
- محمد جواد علاءالدینی
- سید حسن معافی
- امیر توحیدی

# سیستم اعلام وضعیت بسته‌های پستی

<div dir="rtl" style="text-align: right;">


این پروژه یک سیستم اعلام وضعیت بسته‌های پستی است که با استفاده از دو الگوی طراحی Strategy و State پیاده‌سازی شده است.

## الگوی Strategy

در این پروژه، از الگوی طراحی Strategy برای محاسبه قیمت بسته‌ها استفاده شده است. دو روش ارسال بسته تعریف شده‌اند:
- روش `StandardShipping`: محاسبه قیمت به صورت وزن بسته ضرب در 2.5
- روش  `ExpressShipping`: محاسبه قیمت به صورت وزن بسته ضرب در 3.5

## الگوی State

برای مدیریت وضعیت‌های بسته از الگوی طراحی State استفاده شده است. دو وضعیت برای بسته تعریف شده‌اند:
- وضعیت `InTransitState`: وضعیت بسته در حال ارسال
- وضعیت `DeliveredState`: وضعیت بسته تحویل داده شده

## نحوه اجرا

در ابتدا وزن بسته دریافت می‌شود. سپس در یک حلقه تا زمانی که بسته تحویل داده نشده باشد، روش ارسال و وضعیت بسته دریافت می‌شود. کاربر می‌تواند در هر لحظه روش ارسال و وضعیت بسته را تغییر دهد.

## تست‌ها

برای این پروژه از روش TDD استفاده شده است و تست‌های واحد برای بررسی صحت عملکرد کلاس‌ها و متدهای مختلف نوشته شده است.

## دسته‌بندی الگوهای طراحی در کتاب GoF

در کتاب GoF سه دسته الگوی طراحی معرفی شده است:

- **الگوهای آفرینشی (Creational Patterns):** این الگوها به ایجاد اشیاء کمک می‌کنند و فرآیند ایجاد نمونه‌های جدید را ساده‌تر و انعطاف‌پذیرتر می‌سازند. آنها نحوه ایجاد شیء را جدا می‌کنند تا سیستم مستقل از نحوه ایجاد و ترکیب اشیاء باشد.

- **الگوهای ساختاری (Structural Patterns):** این الگوها نحوه ترکیب اشیاء و کلاس‌ها را برای تشکیل ساختارهای بزرگ‌تر تعریف می‌کنند. آنها به اطمینان از اینکه اگر یک بخش از ساختار تغییر کرد، ساختار کل سیستم مختل نشود، کمک می‌کنند.

- **الگوهای رفتاری (Behavioral Patterns):** این الگوها به تعاملات و مسئولیت‌های بین اشیاء و چگونگی ارتباط آنها با یکدیگر می‌پردازند. آنها الگوریتم‌ها و تخصیص مسئولیت‌ها بین اشیاء را تعریف می‌کنند.

## الگوهای استفاده شده در این آزمایش

- **الگوی Strategy Pattern:** جزو الگوهای رفتاری (Behavioral Patterns) است. این الگو به ما اجازه می‌دهد که الگوریتم‌های مختلف را در کلاس‌های جداگانه پیاده‌سازی کنیم و آنها را به صورت پویا در زمان اجرا تغییر دهیم.
- **الگوی State Pattern:** جزو الگوهای رفتاری (Behavioral Patterns) است. این الگو به یک شیء اجازه می‌دهد که رفتار خود را بر اساس وضعیت درونی خود تغییر دهد، به گونه‌ای که به نظر می‌رسد کلاس آن شیء تغییر کرده است.

## انتخاب الگوی طراحی مناسب برای یک بسته

**الگوی طراحی Singleton:**
با توجه به اینکه در هر اجرا تنها یک بسته داریم و نیازی به ایجاد بیش از یک نمونه از بسته نیست، الگوی طراحی Singleton مناسب است. این الگو تضمین می‌کند که تنها یک نمونه از کلاس ایجاد می‌شود و دسترسی به آن نمونه از طریق یک نقطه دسترسی جهانی امکان‌پذیر است.

### علت انتخاب

الگوی Singleton برای مواقعی که باید مطمئن شویم تنها یک نمونه از یک کلاس در برنامه وجود دارد، مناسب است. این الگو به جلوگیری از ایجاد نمونه‌های متعدد و مدیریت ساده‌تر وضعیت شیء کمک می‌کند.

### نحوه تحقق الگو

```java
public class SingletonPackage {
    private static SingletonPackage instance;
    private double weight;
    private ShippingStrategy shippingStrategy;
    private PackageState packageState;

    private SingletonPackage(double weight) {
        this.weight = weight;
        this.shippingStrategy = new StandardShipping(); // Default shipping strategy
        this.packageState = new InTransitState(); // Default state
    }

    public static SingletonPackage getInstance(double weight) {
        if (instance == null) {
            instance = new SingletonPackage(weight);
        }
        return instance;
    }

    public ShippingStrategy getShippingStrategy() {
        return shippingStrategy;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public PackageState getPackageState() {
        return packageState;
    }

    public void setPackageState(PackageState packageState) {
        this.packageState = packageState;
        this.packageState.handleStateChange(this);
    }

    public double calculateCost() {
        return this.shippingStrategy.calculateCost(this.weight);
    }

    public boolean isDelivered() {
        return this.packageState instanceof DeliveredState;
    }
}
```
# اصول SOLID و الگوی Singleton
### اصل Single Responsibility Principle (SRP) 
الگوی Singleton این اصل را نقض می‌کند، زیرا علاوه بر وظیفه اصلی کلاس، وظیفه مدیریت نمونه‌سازی را نیز بر عهده می‌گیرد.

### اصل Open/Closed Principle (OCP)
الگوی Singleton این اصل را نقض می‌کند، زیرا برای تغییر رفتار Singleton (مثل نحوه نمونه‌سازی یا مدیریت نمونه‌ها) باید کد کلاس تغییر کند، نه اینکه به راحتی قابل توسعه باشد.

### اصل Liskov Substitution Principle (LSP)
الگوی Singleton این اصل را تحقق نمی‌بخشد، زیرا ممکن است جایگزینی کلاس Singleton با زیرکلاس آن، رفتار ناخواسته‌ای ایجاد کند، خصوصاً وقتی که زیرکلاس‌ها نیاز به نمونه‌های مجزا داشته باشند.

### اصل Interface Segregation Principle (ISP)
الگوی Singleton معمولاً این اصل را نقض نمی‌کند، زیرا اغلب با رابط‌ها سروکار ندارد. اما اگر Singleton چندین رابط را پیاده‌سازی کند، باید دقت کرد که هر رابط وظایف خاص خود را داشته باشد.

### اصل Dependency Inversion Principle (DIP)
الگوی Singleton می‌تواند این اصل را نقض کند، زیرا اغلب وابستگی‌های سخت به کلاس Singleton ایجاد می‌کند که باعث می‌شود تست‌پذیری و انعطاف‌پذیری کاهش یابد.

</div>
