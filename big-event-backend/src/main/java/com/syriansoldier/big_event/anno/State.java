package com.syriansoldier.big_event.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.auth0.jwt.interfaces.Payload;

// 元注解: 指定可以用于 "字段", 还是 "方法参数", 还是"类/接口"
@Target({ ElementType.FIELD, ElementType.PARAMETER }) // 可用于字段和方法参数

// 元注解: 指定注解在什么时期有效
@Retention(RetentionPolicy.RUNTIME) // 在运行时有效

// 指定注解的校验器是哪个
@Constraint(validatedBy = State.StateValidator.class)
public @interface State {
  // 默认错误消息. 加上这行可以这样调用 @State(message = "")
  String message() default "状态无效";

  // 校验分组. 加上这行可以指定分组. 如 @State(groups = { Add.class })
  Class<?>[] groups() default {};

  // 附加信息. 加上这行可以增加附加信息 如@State(payload = {})
  Class<? extends Payload>[] payload() default {};

  // 校验器的实现类. 每一个校验器需要实现 ConstraintValidator<校验器所关联的注解类型, 校验的数据类型>
  // Tips: 注解的示例指的是 "@注解名称", 如@State, 注解的类型指的是 "注解名称", 如State, 这里指的是注解的类型
  public static class StateValidator implements ConstraintValidator<State, Integer> {

    @Override
    public void initialize(State constraintAnnotation) {
      // 初始化操作（如果有需要的话）
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
      // 校验逻辑： 只能是0或者1
      return (value == 0 || value == 1);
    }
  }
}
